package model.field;

import java.util.*;
import util.*;
import model.*;

public  class PureDate2F extends PureDate2FI
{
        public PureDate2F(Entity parent,String sname,String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(String v)
        {
            this.val = util.DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public void fromUser(String v)
        {
            this.val = util.DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public void fromAdmin(String v)
        {
            this.val = util.DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public String toDb()
        {
            return util.DateUtil.DateToString(val, "yyyy-MM-dd");
        }

        @Override
        public String toUser()
        {
            return util.DateUtil.DateToString(val, "yyyy-MM-dd");
        }

        @Override
        public String toAdmin()
        {
            return util.DateUtil.DateToString(val, "yyyy-MM-dd");
        }
         public util.Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        