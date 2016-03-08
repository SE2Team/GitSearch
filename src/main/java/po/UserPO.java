package po;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/4 0004.
 */
public class UserPO {
    String name;
    String register;
    ArrayList<RepositoryPO> contribute;
    ArrayList<RepositoryPO> creat;

    public UserPO() {
    }

    public UserPO(String name, String register, ArrayList<RepositoryPO> contribute, ArrayList<RepositoryPO> creat) {
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

    public ArrayList<RepositoryPO> getContribute() {
        return contribute;
    }

    public void setContribute(ArrayList<RepositoryPO> contribute) {
        this.contribute = contribute;
    }

    public ArrayList<RepositoryPO> getCreat() {
        return creat;
    }

    public void setCreat(ArrayList<RepositoryPO> creat) {
        this.creat = creat;
    }
}
