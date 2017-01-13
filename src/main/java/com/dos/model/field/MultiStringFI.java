package com.dos.model.field;

import com.dos.model.Entity;
import com.dos.model.FieldI;

import java.util.ArrayList;

public  abstract class MultiStringFI extends FieldI<ArrayList<String>,String,ArrayList<String>,ArrayList<String>>
{
        
        public MultiStringFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        