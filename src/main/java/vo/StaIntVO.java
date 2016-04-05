package vo;

import java.util.ArrayList;

/** 
 * @author 
 * @date 
2016年3月29日 
下午8:36:32 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public class StaIntVO {
	ArrayList<Integer> integer;
	ArrayList<Integer> integer2;
	
	public StaIntVO(ArrayList<Integer> integer,ArrayList<Integer> integer2){
		this.integer=integer;
		this.integer2=integer2;
	}
	
	public ArrayList<Integer> getInt(){
		return this.integer;
	}
	
	public ArrayList<Integer> getint2(){
		return this.integer2;
	}
}
