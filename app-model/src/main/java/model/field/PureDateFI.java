package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class PureDateFI extends FieldI<Date,Date,String,String>
{
        
        public PureDateFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        