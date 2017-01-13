package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

public  abstract class RawTextFI extends FieldI<String,String,String,String>
{
        
        public RawTextFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        