package dataService;



import java.io.IOException;
import java.util.ArrayList;
import po.UserPO;

/**
 * Created by moeyui on 2016/3/7 0007.
 */
public interface CollaboratorsDataService {
    ArrayList<UserPO> NamesOfCollaborators(String url);

    ArrayList<String> getCollaborators(String url) throws IOException;
}
