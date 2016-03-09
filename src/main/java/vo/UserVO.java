package vo;

import po.RepositoryPO;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserVO {
    String name;
    String register;
    ArrayList<RepositoryVO> contribute;
    ArrayList<RepositoryVO> creat;

    public UserVO() {
    }

    public UserVO(String name, String register, ArrayList<RepositoryVO> contribute, ArrayList<RepositoryVO> creat) {
        this.name = name;
        this.register = register;
        this.contribute = contribute;
        this.creat = creat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public ArrayList<RepositoryVO> getContribute() {
        return contribute;
    }

    public void setContribute(ArrayList<RepositoryVO> contribute) {
        this.contribute = contribute;
    }

    public ArrayList<RepositoryVO> getCreat() {
        return creat;
    }

    public void setCreat(ArrayList<RepositoryVO> creat) {
        this.creat = creat;
    }
}
