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
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ParseException{
		APIConnection apiConnection=new APIConnection();
		apiConnection.initAPIConnection();
		JDBCHelper helper=GetJDBC.getJDBCHelper();
		RepositoryPO po=helper.checkRepo("rails", "rails");
		GHRepository dpo=po.getRepository();
		GHCommitQueryBuilder builder=dpo.queryCommits().since(new Time().getNowTime());
		ArrayList<GHCommit> list=(ArrayList<GHCommit>) builder.list().asList();
	//	GHCommitComment comment=new GHCommitComment();
		ArrayList<GHCommitComment> listComment=new ArrayList<>();
		for(int i=0;i<list.size();i++){
			listComment=(ArrayList<GHCommitComment>) list.get(i).listComments().asList();
		}
		
		System.out.println("Success");
		
		

	}
}