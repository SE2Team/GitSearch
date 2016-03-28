package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> dedf045e1437715347a0a50de993be571c0da982
import po.RepositoryPO;
import po.UserPO;

=======
>>>>>>> e88f5669b851aaefa624d09113f26340c244a214


public class Test {
<<<<<<< HEAD
	public static void main(String[] args) throws IOException{
		
//	for(int i=0;i<list2.size();i++){
//			for(int p=i;p<list2.size()-1;p++){
//				if(list2.get(i)>list2.get(p)){
//					temp=list2.get(p);
//					list2.set(p, list2.get(i));
//					list2.set(i, temp);
//	
//				}
//			}
//		}
//	从小到大排序
		Map<String, Integer> map=new StatisticsData().getLanguage();
		Set<String> set=map.keySet();
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			Integer j=map.get(key);
			System.out.println(key+":"+j);
		}
		
	}
<<<<<<< HEAD
=======
=======
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
>>>>>>> e88f5669b851aaefa624d09113f26340c244a214
>>>>>>> dedf045e1437715347a0a50de993be571c0da982
}
