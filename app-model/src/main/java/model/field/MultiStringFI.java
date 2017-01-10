package model.field;

import util.*;
import model.*;
import java.util.*;
import model.field.*;

public  abstract class MultiStringFI extends FieldI<ArrayList<String>,String,ArrayList<String>,ArrayList<String>>
{
        
        public MultiStringFI(Entity parent, String name, String key)
        {
            super(name,key);
            
            this.parent = parent;  
        }


}
        