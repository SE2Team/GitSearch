package vo;

import java.util.ArrayList;

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
