package data;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import po.UserPO;

import java.io.IOException;
import java.util.ArrayList;


public class Test {
    public static void main(String[] args) throws IOException {
//		RepositoryData testRepository=new RepositoryData();
//		ArrayList<String> a=testRepository.getRepositoriesNames();
//		for(int i=0;i<a.size();i++){
//			System.out.println(a.get(i));
        UserData user = new UserData();
        ArrayList<UserPO> list = user.search("mojo");
        for (UserPO po : list) {
            System.out.print(po.getLogin());
        }
        UserBLService bl = new UserController();
        System.out.println(bl.search("mojo").next().getLogin());;

    }
}
