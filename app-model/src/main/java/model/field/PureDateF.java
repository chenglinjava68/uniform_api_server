package model.field;

import java.util.*;
import util.*;
import model.*;

public  class PureDateF extends PureDateFI
{
        public PureDateF(Entity parent,String sname,String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(Date v)
        {
            this.val = v;
        }

        @Override
        public void fromUser(String v)
        {
            this.val = util.DateUtil.StringToDate(v);
        }

        @Override
        public void fromAdmin(String v)
        {
            this.val = util.DateUtil.StringToDate(v);
        }

        @Override
        public Date toDb()
        {
            return this.val;
        }

        @Override
        public String toUser()
        {
            return util.DateUtil.DateToString(this.val);
        }

        @Override
        public String toAdmin()
        {
            return util.DateUtil.DateToString(this.val);
        }
         public util.Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        