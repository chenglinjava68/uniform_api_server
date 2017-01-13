package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.Ret;

public  class RawStringF extends RawStringFI
{
        public RawStringF(Entity parent, String sname, String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(String v)
        {
            this.val = v;
        }

        @Override
        public void fromUser(String v)
        {
            this.val = v;
        }

        @Override
        public void fromAdmin(String v)
        {
            this.val = v;
        }

        @Override
        public String toDb()
        {
            return this.val;
        }

        @Override
        public String toUser()
        {
            return val;
        }

        @Override
        public String toAdmin()
        {
            return val;
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        