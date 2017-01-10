package util.model;

import java.util.*;


public abstract class Store<To> {
	public static class Page<TT>{
		public Page(int onPageI){
			this.onPageItem = onPageI;
		}
		public List<TT> data= new ArrayList<TT>();
		public int totalCount = 0;
		public int page = 1;
		public int countOfPage = 0;
		public int onPageItem = 0;
		public Map<String,Object> toMap(Object dt){
			Map<String,Object> out = new HashMap<String,Object>();
			out.put("total_count", totalCount);
			out.put("page", page);
			out.put("count_of_page", countOfPage);
			out.put("on_page_item", onPageItem);
			if(dt == null){
				out.put("data", data);
			}
			else{
				out.put("data", dt);
			}
			return out;
		}
	};
	public  Page<To> selectPage(String whereParam,String   orderParam, int pageNumber, int onPageItem, boolean dl) throws Exception
	{
		Page<To> np = new Page<To>(onPageItem);
		np.totalCount  = this.count(dl, whereParam);
		if(np.totalCount == 0)
			return np;
		np.countOfPage = np.totalCount / np.onPageItem;
		if(np.totalCount % np.onPageItem > 0)
			np.countOfPage += 1;
		if(pageNumber > np.countOfPage){   //out of range, no data
			np.page = pageNumber;
			return np;
		}
		if(pageNumber<1 )
			pageNumber = 1;
		np.page = pageNumber;
		int limitStart = (np.page-1)*np.onPageItem;
		int limitLength = (np.onPageItem);
		np.data = this.select(dl,whereParam, orderParam, limitStart, limitLength);
		return np;
	}
	protected abstract boolean dLink();
	public int count(String where) throws Exception
	{
		Integer ss =  count(dLink(),where);
		return ss;
	}
	public List<To> select(
	        String   whereParam,
	        String   orderParam,
	        Integer  limitStart,
	        Integer limitLength
		) throws Exception
	{
		return select(dLink(),whereParam,orderParam,limitStart,limitLength);
	}
	public abstract boolean isExist(Integer id) throws Exception;
	public To get(String whereParam) throws Exception
	{
		if(this.count(whereParam)==0)
			return null;
		return get(dLink(),whereParam);
	}
	public To getById(Integer id) throws Exception
	{
		if(!this.isExist(id))
			return null;
		return getById(dLink(),id);
	}
	public List<To> getByIdList(boolean deepLink, List<Integer> idList) throws Exception
	{
	    if(idList == null || idList.size() == 0 )
	        return new ArrayList();
	    if(idList.size() == 1)
	    {
	        Integer sId = idList.get(0);
	        List<To> sRet = new ArrayList<To>();
	        sRet.add(getById(sId));
	        return sRet;
	    }
	    else
	    {
            return __GetByIdList(deepLink,idList);
	    }
	}
	protected abstract List<To> __GetByIdList(boolean deepLink, List<Integer> idList) throws Exception;
	public abstract int count(boolean deepLink,String where) throws Exception;
	public abstract List<To> select(
			boolean deepLink,
	        String   whereParam,
	        String   orderParam,
	        Integer  limitStart,
	        Integer limitLength
		) throws Exception;
	public abstract To get(boolean deepLink,String whereParam) throws Exception;
	public abstract To getById(boolean deepLink,Integer id) throws Exception;
	
	public abstract int insert(To po) throws Exception;
	public abstract int update(To po) throws Exception;
	public abstract int update2(To po) throws Exception;
	public abstract int updateSql(String sql) throws Exception;
}
