package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

public  abstract class RawDoubleFI extends FieldI<Double,Double,Double,Double>
{
        
        public RawDoubleFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        