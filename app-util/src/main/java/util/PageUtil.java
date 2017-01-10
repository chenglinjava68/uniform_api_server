package util;

/** 
 * @author wujianguo 
 * @version V1.1 
 * 类说明 
 */
public class PageUtil {
	public static final int PAGE_SIZE = 20;
	
	public static int processPageAndMaxPage(Long page, int maxPage){
		if(page == null || page < 1)
			page = 0L;
		else
			page = page -1;
		if(page > maxPage)
			page = (long)maxPage;
		return page.intValue();
	}	
}
