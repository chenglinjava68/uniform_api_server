package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.util.Ret;

public  class RawDoubleF extends RawDoubleFI
{
        public RawDoubleF(Entity parent, String sname, String skey  )
        {
            super(parent,sname,skey );
        }

        @Override
        public void fromDb(Double v)
        {
            this.val = v;
        }

        @Override
        public void fromUser(Double v)
        {
            this.val = v;
        }

        @Override
        public void fromAdmin(Double v)
        {
            this.val = v;
        }

        @Override
        public Double toDb()
        {
            return this.val;
        }

        @Override
        public Double toUser()
        {
            return val;
        }

        @Override
        public Double toAdmin()
        {
            return val;
        }
         public Ret check(String mode)
         {
            return extraCheck(mode);
         }
	    public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
        