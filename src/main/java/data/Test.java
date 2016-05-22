package data;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHCommitComment;
import org.kohsuke.github.GHCommitQueryBuilder;
import org.kohsuke.github.GHRepository;

import po.RepositoryPO;




public class Test {
	@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) throws IOException, ParseException{
		APIConnection apiConnection=new APIConnection();
		apiConnection.initAPIConnection();
		JDBCHelper helper=GetJDBC.getJDBCHelper();
		RepositoryPO po=helper.checkRepo("rails", "rails");
		GHRepository dpo=po.getRepository();
		ArrayList<Integer> listInt=new ArrayList<>();
		ArrayList<String> listStr=new ArrayList<>();
		GHCommitQueryBuilder builder=dpo.queryCommits().since(new Time().getNowTime(0));
		ArrayList<GHCommit> list=(ArrayList<GHCommit>) builder.list().asList();
	//	GHCommitComment comment=new GHCommitComment();
		ArrayList<GHCommitComment> listComment=new ArrayList<>();
		
		
		System.out.println("Success");
		
		

	}
}