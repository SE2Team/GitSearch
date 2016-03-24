package presentation.userCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

/**
 * Created by moeyui on 2016/3/15 0015.
 */
public class UserCheckController implements MyController{
    private UserVO vo;
    @FXML
    private Label name;
    @FXML
    private Label regTime;
    @FXML
    private Label company;
    @FXML
    private Label followers;
    @FXML
    private Label email;
    @FXML
    private Label following;
    @FXML
    private Label login;
    @FXML
    private GridPane poprepo;



    private FXUITest fxui;

    @FXML
    public void initialize(){

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        regTime.setText(vo.getCreated());
        String comp=vo.getCompany().replaceAll(" ","")==""?"Unknown":vo.getCompany();
        //// TODO: 2016/3/22 0022 卧槽这里怎么判断公司是不是空的啊？！！
        System.out.println(vo.getCompany().length());
        company.setText(comp);
        followers.setText(String.valueOf(vo.getFollowers()));
        email.setText(vo.getEmail());
        following.setText(String.valueOf(vo.getFollowing()));
        login.setText(vo.getLogin());
//        poprepo.getChildren().set(0,vo.get)
        fxui.push();
    }

    /**
     * get vo with arrays
     * @param vo
     */
    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
