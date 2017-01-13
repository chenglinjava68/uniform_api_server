package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

public  abstract class RawIntegerFI extends FieldI<Integer,Integer,Integer,Integer>
{
        
        public RawIntegerFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        