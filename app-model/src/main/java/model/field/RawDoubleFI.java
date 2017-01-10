package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class RawDoubleFI extends FieldI<Double,Double,Double,Double>
{
        
        public RawDoubleFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        