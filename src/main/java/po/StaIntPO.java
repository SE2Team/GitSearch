package po;

import java.util.ArrayList;

public class StaIntPO {
	ArrayList<Integer> integer2;
	ArrayList<Integer> integer;
	public StaIntPO(ArrayList<Integer> integer,
			ArrayList<Integer> integer2){
		this.integer2=integer2;
		this.integer=integer;
	}
	
	public ArrayList<Integer> getInt2(){
		return this.integer2;
	}
	
	public ArrayList<Integer> getInt(){
		return this.integer;
	}
}
