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
	
	public ArrayList<Integer> getInt2(){
		return this.integer2;
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
	
	public int getSum1(){
		int a=0;
		for(int i=0;i<integer2.size();i++){
			a=integer2.get(i)+a;
		}
		return 0;
	}
	
	public int getSum1(int n){
		int a=0;
		for(int i=n;i<integer2.size();i++){
			a=a+integer2.get(i);
		}
		return a;
	}
}
