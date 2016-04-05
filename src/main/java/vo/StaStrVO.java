package vo;

import java.util.ArrayList;

/** 
 * @author 
 * @date 
2016年3月29日 
下午8:37:06 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class StaStrVO {

	ArrayList<String> str;
	ArrayList<Integer> integer;
	public StaStrVO(ArrayList<String> str,
			ArrayList<Integer> integer){
		this.str=str;
		this.integer=integer;
	}
	
	public ArrayList<String> getStr(){
		return this.str;
	}
	
	public ArrayList<Integer> getInt(){
		return this.integer;
	}
}
