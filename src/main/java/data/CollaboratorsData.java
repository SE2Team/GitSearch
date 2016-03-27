package data;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dataService.CollaboratorsDataService;
import po.UserPO;

public class CollaboratorsData implements CollaboratorsDataService {

	public ArrayList<UserPO> NamesOfCollaborators(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getCollaborators(String url) throws IOException {
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
