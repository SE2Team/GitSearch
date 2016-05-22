package data;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHCommitQueryBuilder;
import org.kohsuke.github.GHRepository;

import po.RepositoryPO;

public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ParseException {
		APIConnection apiConnection = new APIConnection();
		apiConnection.initAPIConnection();
		JDBCHelper helper = GetJDBC.getJDBCHelper();
		RepositoryPO po = helper.checkRepo("rails", "rails");
		GHRepository dpo = po.getRepository();
		ArrayList<Integer> listInt = new ArrayList<>();
		ArrayList<String> listStr = new ArrayList<>();
		SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
		Date day;
		day = new Time().getNowTime(0);
		for (int p = 5; p >= 0; p--) {
			if (Integer.parseInt(sdp.format(day).substring(5, 7)) - p > 0) {
				listStr.add(Integer.parseInt(sdp.format(day).substring(5, 7)) - p + "");
			} else {
				listStr.add(Integer.parseInt(sdp.format(day).substring(5, 7)) - p + 12 + "");
			}

		}
		
		for (int i = 5; i >= 0; i--) {
			day = (Date) new Time().getNowTime(i);
			System.out.println("!");
			GHCommitQueryBuilder builder = dpo.queryCommits().since(day);
			ArrayList<GHCommit> list = (ArrayList<GHCommit>) builder.list().asList();
			listInt.add(list.size());

		}
		
		for (int i = 0; i < listInt.size() - 1; i++) {
			System.out.println(listInt.get(i));
			listInt.set(i, listInt.get(i) - listInt.get(i+1) );
		}
		
		for (int i = 0; i <= listInt.size(); i++) {
			System.out.println(listStr.get(i) +":"+ listInt.get(i));
		}
		System.out.println("Success");

	}
}