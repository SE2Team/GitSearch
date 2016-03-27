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
		ArrayList<String> list=new ArrayList<String>();
		list=data.getString(url);
		return list;
	}

	
}
