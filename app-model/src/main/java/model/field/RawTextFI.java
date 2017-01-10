package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class RawTextFI extends FieldI<String,String,String,String>
{
        
        public RawTextFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        