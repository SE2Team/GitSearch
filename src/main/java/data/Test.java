package data;


import java.io.IOException;


public class Test {
	public static void main(String[] args) throws IOException{

		UserData data=new UserData();
		System.out.print(data.getUser().get(0).getCompany());
		

	}
}