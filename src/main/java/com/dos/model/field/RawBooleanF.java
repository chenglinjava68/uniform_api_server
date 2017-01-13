package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.Ret;

public  class RawBooleanF extends RawBooleanFI
{
        public RawBooleanF(Entity parent, String sname, String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(Integer v)
        {
            this.val = v != null ? v == 1 : false;
        }

        @Override
        public void fromUser(Boolean v)
        {
            this.val = v;
        }

        @Override
        public void fromAdmin(Boolean v)
        {
            this.val = v;
        }

        @Override
        public Integer toDb()
        {
            if(this.val)
                return 1;
            else
                return 0;
        }

        @Override
        public Boolean toUser()
        {
            return val;
        }

        @Override
        public Boolean toAdmin()
        {
            return val;
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        