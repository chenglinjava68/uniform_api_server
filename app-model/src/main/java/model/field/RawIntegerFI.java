package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class RawIntegerFI extends FieldI<Integer,Integer,Integer,Integer>
{
        
        public RawIntegerFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        