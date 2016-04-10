package businesslogicService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import Util.UserInfo;
import Util.User_Sort;
import vo.UserVO;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public interface UserBLService {
    /**
     * 鏌ヨ鏌愪釜user鐨勮缁嗕俊鎭紙杩欓噷鐨剈ser鏄」鐩腑contributor鎴朿ollaborator鐨勭櫥褰曞悕锛?
     *
     * @param user
     * @return
     */
    UserVO CheckUser(String user) throws IOException;


    /**
     * 鏌ヨ鏌愪釜user鐨勬煇椤逛俊鎭紙杩欓噷鐨剈ser鏄」鐩腑contributor鎴朿ollaborator鐨勭櫥褰曞悕锛?
     *
     * @param name
     * @param info item鍙帴鍙楃殑鍙傛暟鏈夛細
     *             id,login,type,name
     *             company,blog,location,email,bio
     *             public_repos,public_gists,followers,following
     *             created_at,updated_at
     * @return
     */
    String UserInfo(String name, UserInfo info) throws IOException;

    /**
     * 鏌ヨ鍗曚釜椤圭洰鐨勭偣璧炶??,涓?椤?50涓?
     *
     * @param userName
     * @param reponame String stargazers
     * @return
     */
    Iterator<String> getStargazers(String userName, String reponame) throws IOException;

    /**
     * 鏌ヨ鍗曚釜椤圭洰鐨勭偣璧炶?呯櫥褰曞悕,涓?椤?50涓?
     *
     * @param userName
     * @param reponame
     * @return
     */

    Iterator<String> getStargazerNames(String userName, String reponame) throws IOException;

    /**
     * 鏌ヨ鍗曚釜椤圭洰鐨勮闃呰??,涓?椤?50涓?
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<UserVO> getSubscribers(String userName, String reponame);

    /**
     * 鏌ヨ鍗曚釜椤圭洰鐨勮闃呰?呯櫥褰曞悕,涓?椤?50涓?
     *
     * @param userName
     * @param reponame
     * @return
     */
    Iterator<String> NamesOfSubscriber(String userName, String reponame) throws IOException;

    /**
     * 鎸夊叧閿瓧鎼滅储鐢ㄦ埛
     *
     * @param name 鍏抽敭瀛?
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    Iterator<UserVO> search(String name) throws FileNotFoundException, IOException;

    Iterator<UserVO> getUser() throws IOException;
    
    Iterator<UserVO> sortUser(User_Sort sort) throws IOException;
    
    Iterator<UserVO> screenTime(String time) throws IOException;
}
