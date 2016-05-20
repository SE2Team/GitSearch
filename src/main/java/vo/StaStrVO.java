package vo;

import java.util.ArrayList;

public class StaStrVO {

	ArrayList<String> x;
	ArrayList<Integer> y;
	public StaStrVO(ArrayList<String> x,
			ArrayList<Integer> y){
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<String> getX(){
		return this.x;
	}
	
	public ArrayList<Integer> getInt(){
		return this.y;
	}
	
	public int getSum(){
		int a=0;
		for(int i = 0; i< y.size(); i++){
			a= y.get(i)+a;
		}
		return 0;
	}
	
	public int getSum(int n){
		int a=0;
		for(int i = n; i< y.size(); i++){
			a=a+ y.get(i);
		}
		return a;
	}
}
