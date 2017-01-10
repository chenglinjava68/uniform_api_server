package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class PureDate2FI extends FieldI<Date,String,String,String>
{
        
        public PureDate2FI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        