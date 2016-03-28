package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import po.RepositoryPO;
import po.UserPO;



public class Test {
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
}
