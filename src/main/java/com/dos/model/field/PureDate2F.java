package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.DateUtil;
import com.dos.util.Ret;

public  class PureDate2F extends PureDate2FI
{
        public PureDate2F(Entity parent, String sname, String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(String v)
        {
            this.val = DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public void fromUser(String v)
        {
            this.val = DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public void fromAdmin(String v)
        {
            this.val = DateUtil.StringToDate(v, "yyyy-MM-dd");
        }

        @Override
        public String toDb()
        {
            return DateUtil.DateToString(val, "yyyy-MM-dd");
        }

        @Override
        public String toUser()
        {
            return DateUtil.DateToString(val, "yyyy-MM-dd");
        }

        @Override
        public String toAdmin()
        {
            return DateUtil.DateToString(val, "yyyy-MM-dd");
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        