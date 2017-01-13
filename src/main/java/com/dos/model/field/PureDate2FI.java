package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

import java.util.Date;

public  abstract class PureDate2FI extends FieldI<Date,String,String,String>
{
        
        public PureDate2FI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        