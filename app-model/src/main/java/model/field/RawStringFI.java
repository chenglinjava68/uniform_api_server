package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class RawStringFI extends FieldI<String,String,String,String>
{
        
        public RawStringFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        