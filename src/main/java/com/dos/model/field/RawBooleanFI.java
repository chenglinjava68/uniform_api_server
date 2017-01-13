package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

public  abstract class RawBooleanFI extends FieldI<Boolean,Integer,Boolean,Boolean>
{
        
        public RawBooleanFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        