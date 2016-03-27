package businesslogicService;

import vo.UserVO;

import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/7 0007.
 */
public interface CollaboratorsBLService {
    Iterator<UserVO> NamesOfCollaborators(String userName, String reponame);

    Iterator<String> getCollaborators(String userName, String reponame);
}
