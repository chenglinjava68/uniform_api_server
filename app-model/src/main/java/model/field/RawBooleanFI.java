package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class RawBooleanFI extends FieldI<Boolean,Integer,Boolean,Boolean>
{
        
        public RawBooleanFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        