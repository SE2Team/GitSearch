package dataService;



import java.util.ArrayList;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/7 0007.
 */
public interface CollaboratorsDataService {
    ArrayList<UserPO> NamesOfCollaborators(String userName, String reponame);

    ArrayList<String> getCollaborators(String userName, String reponame);
}
