package model;

import java.util.*;

import util.Ret;

public class IdPostParam implements model.PVoParamI
{
		Integer id;
		
		public IdPostParam(){
			
		}
		public IdPostParam(Integer sid){
			id = sid;
		}
		
		public static IdPostParam  withId(Integer sid){
			return new IdPostParam(sid);
		}

		@Override
		public Object key(String key) {
			if("id".equals(key)) return this.id;
			return null;
		}

		@Override
		public void key(String key, Object o) {
			if("id".equals(key))
				this.id = (Integer)o;

		}

		@Override
		public Ret check() {
			if(this.id == null)
				return Ret.no("ID未设置");
			return Ret.ok("");
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}


}