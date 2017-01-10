#coding=utf-8
import os as system;
import json;


class basic_fun:
    @staticmethod
    def shorten_prop_name(val):
        if len(val) < 9 and val.lower() == val:
            return val;
        if len(val) < 6:
            return val;
        out = val[0];
        for uv in val[1:]:
            if not uv.islower() or uv.isdigit():
                out = out + uv;
        outlen = len(out);
        if outlen < 3:
            out = out + val[outlen - 3:];
        return out.lower();
    @staticmethod
    def upper_first(val):
        if len(val) == 1:
            return val.upper();
        else:
            return val[0].upper() + val[1:];
    @staticmethod
    def camel_to_underline(camel_format):
        underline_format = ''
        for _s_ in camel_format:
            underline_format += _s_ if _s_.islower() else '_' + _s_.lower()
        return underline_format;
    @staticmethod
    def underline_to_camel(underline_format):
        camel_format = ''
        for _s_ in underline_format.split('_'):
            camel_format += _s_.capitalize()
        return camel_format;

class method_param:
    _name = "";
    _type = "";
    _def  = "";
    def __init__(self,name,type,sdef):
        self._name = name;
        self._type = type;
        self._def = sdef;
    def name(self):
        return self._name;
    def type(self):
        return self._type;
    def get_def(self):
        return self._def;

class field:
    _name = "";
    _type = "";
    _db_type = "";
    _user_type = "";
    _admin_type = "";
    _includes = [];
    _package = "util.model.field";
    _dir = "src/main/java/util/model/field";
    _init_params = [];
    _dt_type = "pure"; ##ArrayList,Entity
    def __init__(self,name,t,dt_type="pure"):
        self._name = name;
        self._type = t;
        self._db_type = self._type;
        self._user_type = self._type;
        self._admin_type = self._type;
        self._includes = [];
        self._package = "util.model.field";
        self._dir = "src/main/java/util.model/field";
        self._init_params = [];
        self._dt_type = dt_type;
    def dt_type(self):
        return self._dt_type;
    def init_params(self):
        return self._init_params;
    def name(self):
        return self._name;
    def type(self):
        return  self._type;
    def db(self):
        return self._db_type;
    def user(self):
        return self._user_type;
    def admin(self):
        return self._admin_type;
    def includes(self):
        return self._includes;
    def package(self):
        return self._package;
    def dir(self):
        return self._dir;
    def for_db(self,val):
        self._db_type = val;
        return self;
    def for_user(self,val,also_for_admin=True):
        self._user_type = val;
        if also_for_admin:
            self._admin_type = val;
        return self;
    def for_admin(self,val):
        self._admin_type = val;
        return self;
    def add_include(self,val):
        if not(val in self._includes):
            self._includes.append(val);
        return self;
    def set_dt_type(self,val):
        self._dt_type = val;
        return self;
    def set_package(self,val):
        self._package = val;
        return self;
    def set_dir(self,val):
        self._dir = val;
        return self;
    def add_init_param(self,methodparam):
        self._init_params.append(method_param);
        return self;
    def equal_db(self):
        return self._type == self._db_type;
    def equal_user(self):
        return self._user_type == self._type;
    def equal_admin(self):
        return self._admin_type == self._type;
    def uniform_name(self):
        return basic_fun.upper_first(self.name());
    def interface_name(self):
        return self.uniform_name() + "FieldI";
    def implement_name(self):
        return self.uniform_name() + "Field";
    def create_interface_output(self):
        template = """
        package $package;
        import util.*;
        import java.util.*;
        import $package.*;

        $additionInclude

        public  abstract class $interfaceName extends VOI<$Type,$dbType,$userType,$adminType>{
            $initParamInit
            public $interfaceName(TEntity parent, String name, String key$initParamList){
                super(name,key);
                $interfaceInit
                this.parent = parent;  $initParamSet
            }
        }
        """;
        outStr = template.replace("$interfaceName",self.interface_name());
        if self._dt_type == "pure":
            outStr = outStr.replace("$interfaceInit", "");
        else:
            outStr = outStr.replace("$interfaceInit", "this.val = new "+self._type+"();");
        additionInclude = "";
        for ui in self._includes:
            if not ui.startswith("import "):
                ui = "import " + ui;
            if not ui.startswith(";"):
                ui = ui + ";";
            ui = ui + "\r\n";
            additionInclude = additionInclude + ui;
        outStr = outStr.replace("$additionInclude", additionInclude);
        outStr = outStr.replace("$Type", self.type());
        outStr = outStr.replace("$dbType", self.db());
        outStr = outStr.replace("$userType", self.user());
        outStr = outStr.replace("$adminType", self.admin());
        initParamList = "";
        for up in self._init_params:
            initParamList = initParamList + "," + up.type() + " "+ up.name();
        outStr = outStr.replace("$initParamList", initParamList);
        initParamSet = "";
        for up in self._init_params:
            initParamSet = initParamSet + " this." + up.name() + " = "+ up.name() + ";\r\n        ";
        outStr = outStr.replace("$initParamSet", initParamSet);
        initParamInit = "";
        for up in self._init_params:
            initParamInit = initParamInit + "private " + up.type() + " " + up.name();
            sdef = up.get_def();
            if len(sdef) > 0:
                initParamInit = initParamInit + " = " + sdef + " ";
            initParamInit = initParamInit + ";\r\n    ";
        outStr = outStr.replace("$initParamInit", initParamInit);
        outStr = outStr.replace("$package", self.package());
        return outStr;
    def create_implement_output(self):
        template = """
        package $package;
        import java.util.*;
        import util.*;
        import util.model.*;

        $additionInclude

        public  class $implementName extends $interfaceName{
            public $implementName(Entity parent,String sname,String skey  $initParamList){
                super(parent,sname,skey $initParamLis2);
            }

            @Override
        	public void fromDb($dbType v) {
        	    $fromDbVal
        	}

        	@Override
        	public void fromUser($userType v) {
        		$fromUserVal
        	}

        	@Override
        	public void fromAdmin($adminType v) {
        		$fromAdminVal
        	}

        	@Override
        	public $dbType toDb() {
        		$toDbVal
        	}

        	@Override
        	public $userType toUser() {
        		$toUserVal
        	}

        	@Override
        	public $adminType toAdmin() {
        		$toAdminVal
        	}
        }
        """;
        outStr = template.replace("$interfaceName", self.interface_name());
        outStr = template.replace("$implementName", self.implement_name());

        additionInclude = "";
        for ui in self._includes:
            if not ui.startswith("import "):
                ui = "import " + ui;
            if not ui.startswith(";"):
                ui = ui + ";";
            ui = ui + "\r\n";
            additionInclude = additionInclude + ui;
        outStr = outStr.replace("$additionInclude", additionInclude);
        outStr = outStr.replace("$Type", self.type());
        outStr = outStr.replace("$dbType", self.db());
        outStr = outStr.replace("$userType", self.user());
        outStr = outStr.replace("$adminType", self.admin());
        initParamList = "";
        for up in self._init_params:
            initParamList = initParamList + "," + up.type() + " " + up.name();
        outStr = outStr.replace("$initParamList", initParamList);
        initParamList2 = "";
        for up in self._init_params:
            initParamList2 = initParamList2 + "," + up.name();
        outStr = outStr.replace("$initParamLis2", initParamList2);
        outStr = outStr.replace("$package", self.package());
        #fromDbVal
        fromDbVal = "";
        if self._dt_type == "pure":
            fromDbVal = "this.val = v;";
        else:
            if self._dt_type == "Entity":
                fromDbVal = "this.val.fromDbMemo(v);";
            else:
                fromDtVal = """
                        this.val.clear();
                        if(v!=null && !v.isEmpty())
                		v.forEach(po->{
                			$rawType entity = new $rawType();
                			entity.fromDbMemo(po);
                			this.val.add(entity);
                		});""";
                fromDtVal = fromDtVal.replace("$rawType", self.type().replace("ArrayList<", "").replace(">", ""));
        outStr = outStr.replace("$fromDbVal", fromDbVal);
        #fromUserVal
        fromUserVal = "";
        if self._dt_type == "pure":
            fromUserVal = "this.val = v;";
        else:
            fromUserVal = "";
        outStr = outStr.replace("$fromUserVal", fromUserVal);
        #fromAdminVal
        fromAdminVal = "";
        if self._dt_type == "pure":
            fromAdminVal = "this.val = v;";
        else:
            fromAdminVal = "";
        outStr = outStr.replace("$fromAdminVal", fromAdminVal);
        # toDbVal
        toDbVal = "";
        if self._dt_type == "pure":
            toDbVal = "return this.val.toDbMemo();";
        else:
            if self._dt_type == "Entity":
                toDbVal = "return this.val.toDbMemo();";
            else:
                toDbVal = """
                $rawType ret = new $rawType();
        if(this.val!=null && !this.val.isEmpty())
		this.val.forEach(dv->ret.add(dv.toDbMemo()));
		return ret;
                """;
                toDbVal = toDbVal.replace("$rawType", self.db());
        outStr = outStr.replace("$toDbVal", toDbVal);
        # toUserVal
        toUserVal = "";
        if self._dt_type == "pure":
            toUserVal = "return val;";
        else:
            if self._dt_type == "Entity":
                toUserVal = "return new $rawType(this.val);".replace("$rawType",self.user());
            else:
                toUserVal = """
                ArrayList<$rawType> ret = new ArrayList<$rawType>();
                if(this.val!=null && !this.val.isEmpty())
		            this.val.forEach(dv->ret.add(new $rawType(dv)));
		        return ret;""";
                toUserVal = toDbVal.replace("$rawType", self.user());
        outStr = outStr.replace("$toUserVal", toUserVal);
        # toAdminVal
        toAdminVal = "";
        if self._dt_type == "pure":
            toAdminVal = "return val;";
        else:
            if self._dt_type == "Entity":
                toAdminVal = "return new $rawType(this.val);".replace("$rawType", self.admin());
            else:
                toAdminVal = """
                        ArrayList<$rawType> ret = new ArrayList<$rawType>();
                        if(this.val!=null && !this.val.isEmpty())
        		            this.val.forEach(dv->ret.add(new $rawType(dv)));
        		        return ret;""";
                toUserVal = toDbVal.replace("$rawType", self.admin());
        outStr = outStr.replace("$toAdminVal", toAdminVal);
        return outStr;

fd = field("RawInteger","Integer").for_db("Integer").for_user("Integer");
print(fd.create_interface_output());

print("Implement File");
print(fd.create_implement_output());





