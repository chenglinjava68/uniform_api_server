package com.dos.model;

import com.dos.model.field.RawIntegerF;
import com.dos.util.Ret;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity<Po> {
	@SuppressWarnings("rawtypes")
	protected List<FieldI> vos = new ArrayList<FieldI>();

	private RawIntegerF id = new RawIntegerF(this,"ID","id");
	public RawIntegerF getId(){ return id; }
	public void setId(RawIntegerF id) { this.id = id; }
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
	    	vo.fromDb(ov);
	    });
	    for(FieldI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.cFalse()) return r;
	    }
	    return Ret.ok("");
	}

	public Ret fromUserMemo(PParamI p){
		this.vos.forEach(vo->{
	    	Object ov = p.key(vo.getKey());
	    	vo.fromUser(ov);
	    });
	    for(FieldI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.cFalse()) return r;
	    }
	    return Ret.ok("");
	}

	public Ret fromAdminMemo(PParamI p){
		this.vos.forEach(vo->{
	    	Object ov = p.key(vo.getKey());
	    	vo.fromAdmin(ov);
	    });
	    for(FieldI tvo: vos){
	    	Ret r = tvo.check("common");
	    	if(r.cFalse()) return r;
	    }
	    return Ret.ok("");
	}

}
