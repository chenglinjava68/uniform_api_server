package util.model;

import java.util.*;
import util.*;

public abstract class VOI<T,DT,VT,AT> {
    protected Entity    parent = null;
    public Entity getParent() {	return parent;	}	public void setParent(Entity parent) {	this.parent = parent;	}
	protected T          val    = null;
	public T getVal() {	return val;	}	            public void setVal(T v) {	if(this.val == null || (!this.val.equals(v)) ) {this.val = v; updateFlag = true;}	}
	public T get() {	return val;	}	            public void set(T v) {	setVal(v);	} public void edit(T v) {	setVal(v);	updateFlag = true; }
    protected boolean    updateFlag = false;
    public boolean isUpdated() { return updateFlag;}
    public VOI<T,DT,VT> updateInit() { this.updateFlag = false; return this; }
    public void setUpdateFlag(boolean val) { updateFlag = val; }
    public VOI(String name, String key){
        this.name = name;
        this.key = key;
    }
    protected String name;  public String getName() {  return name;	}
    protected String key;   public String getKey() {  return key;	}

	public abstract void fromDb(DT v);
	public abstract void fromUser(VT v);
	public abstract void fromAdmin(AT v);
    public abstract DT toDb();
    public abstract VT toUser();
    public abstract AT toAdmin();


	public abstract util.Ret check(String mode);
	public  Ret extraCheck(String mode){ return Ret.ok(""); }
}
