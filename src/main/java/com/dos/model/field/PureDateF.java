package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.DateUtil;
import com.dos.util.Ret;

import java.util.Date;

public  class PureDateF extends PureDateFI
{
        public PureDateF(Entity parent, String sname, String skey  )
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
            this.val = DateUtil.StringToDate(v);
        }

        @Override
        public void fromAdmin(String v)
        {
            this.val = DateUtil.StringToDate(v);
        }

        @Override
        public Date toDb()
        {
            return this.val;
        }

        @Override
        public String toUser()
        {
            return DateUtil.DateToString(this.val);
        }

        @Override
        public String toAdmin()
        {
            return DateUtil.DateToString(this.val);
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        