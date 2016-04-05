package vo;

import java.util.ArrayList;

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
