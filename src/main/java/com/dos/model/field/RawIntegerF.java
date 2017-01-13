package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.Ret;

public  class RawIntegerF extends RawIntegerFI
{
        public RawIntegerF(Entity parent, String sname, String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(Integer v)
        {
            this.val = v;
        }

        @Override
        public void fromUser(Integer v)
        {
            this.val = v;
        }

        @Override
        public void fromAdmin(Integer v)
        {
            this.val = v;
        }

        @Override
        public Integer toDb()
        {
            return this.val;
        }

        @Override
        public Integer toUser()
        {
            return val;
        }

        @Override
        public Integer toAdmin()
        {
            return val;
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        