package data;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dataService.ContributorsDataService;
import po.UserPO;

public class ContributorsData implements ContributorsDataService {


	public ArrayList<UserPO> NamesOfContributors(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getContributors(String url) throws IOException {
		// TODO Auto-generated method stub
		GetData data=new GetData();
		if(url.equals("")){
			return null;
		}
		String string=data.getString1(url);
		JSONArray obj1 = new JSONArray(string);
		JSONObject obj = new JSONObject();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<obj1.length();i++){
			obj=obj1.getJSONObject(i);
			list.add(obj.getString("login"));
		}
		return list;
	}

	

}
