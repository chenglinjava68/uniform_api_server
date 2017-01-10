package model.field;

import java.util.*;
import util.*;
import model.*;

public  class MultiStringF extends MultiStringFI
{
        public MultiStringF(Entity parent,String sname,String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(String v)
        {
            if(v == null || v.isEmpty())
                this.val.clear();
            else
                this.val = (ArrayList)(util.JsonUtil.parseString(v, ArrayList.class));
        }

        @Override
        public void fromUser(ArrayList<String> v)
        {
            this.val = v;
        }

        @Override
        public void fromAdmin(ArrayList<String> v)
        {
            this.val = v;
        }

        @Override
        public String toDb()
        {
            try {
                        return util.JsonUtil.stringify(this.val);
                } catch (Exception e) {
                        e.printStackTrace();
                        return "[]";
                }
        }

        @Override
        public ArrayList<String> toUser()
        {
            return val;
        }

        @Override
        public ArrayList<String> toAdmin()
        {
            return val;
        }
         public util.Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        