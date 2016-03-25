package businesslogic.RepositoryBL;

import businesslogicService.CollaboratorsBLService;
import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/7 0007.
 */
public class CollaboratorsController implements CollaboratorsBLService{
	Collaborators collaborators=new Collaborators();
    public Iterator<UserVO> NamesOfCollaborators(String userName, String reponame) {
        return null;
    }

    public Iterator<String> getCollaborators(String userName, String reponame) {
        return collaborators.getCollaboratros(userName, reponame);
    }
}
