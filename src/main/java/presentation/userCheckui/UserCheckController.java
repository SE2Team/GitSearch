package presentation.userCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Label updateTime;
    @FXML
    private Label following;
    @FXML
    private Label login;



    private FXUITest fxui;

    @FXML
    public void initialize(){

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        regTime.setText(vo.getCreated_at());
        company.setText(vo.getCompany());
        followers.setText(String.valueOf(vo.getFollowers()));
        email.setText(vo.getEmail());
        updateTime.setText(vo.getUpdated_at());
        following.setText(String.valueOf(vo.getFollowing()));
        login.setText(vo.getLogin());
        // TODO: 2016/3/16 0016   need more...
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
