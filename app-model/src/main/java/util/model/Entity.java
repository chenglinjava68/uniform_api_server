package util.model;

import java.util.ArrayList;
import java.util.List;

import util.model.vos.*;

import util.Ret;

public abstract class Entity<Po> {
	@SuppressWarnings("rawtypes")
	protected List<VOI> vos = new ArrayList<VOI>();
	
	private PureIntegerVP id = new PureIntegerVP(this,"ID","id");
	public  PureIntegerVP getId(){ return id; }
	public void setId(PureIntegerVP id) { this.id = id; }
	public Entity(){
		vos.add(id);
		this.extraInit();
	}
	
	protected abstract void extraInit();
	protected abstract Ret extraSet(String mode, PParamI p);
	public abstract Po toDbMemo();
	
	public Ret fromDbMemo(PParamI p)
	{
		if(p == null)
			return Ret.ok("");
		
	    this.vos.forEach(vo->{
	    	Object ov = p.key(vo.getKey());
	    	vo.fromDT(ov);
	    });
	    for(VOI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.isFalse()) return r;
	    }
	    return Ret.ok("");
	}
	
	public Ret fromUserMemo(PParamI p){
		this.vos.forEach(vo->{
	    	Object ov = p.key(vo.getKey());
	    	vo.fromVT(ov);
	    });
	    for(VOI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.isFalse()) return r;
	    }
	    return Ret.ok("");
	}

	public Ret fromAdminMemo(PParamI p){
		this.vos.forEach(vo->{
	    	Object ov = p.key(vo.getKey());
	    	vo.fromVT(ov);
	    });
	    for(VOI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.isFalse()) return r;
	    }
	    return Ret.ok("");
	}

}
