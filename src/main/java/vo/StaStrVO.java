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
	
	public int getSum(){
		int a=0;
		for(int i=0;i<integer.size();i++){
			a=integer.get(i)+a;
		}
		return 0;
	}
	
	public int getSum(int n){
		int a=0;
		for(int i=n;i<integer.size();i++){
			a=a+integer.get(i);
		}
		return a;
	}
}
