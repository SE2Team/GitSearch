package data;

import java.io.IOException;
import java.util.ArrayList;



public class Test {
	public static void main(String[] args) throws IOException{
		ArrayList<Integer> list=new StatisticsData().getForks();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
			
		
	}
}
