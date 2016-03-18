package presentation.searchui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class SubUserInfoController implements MyController {
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label followers;
    @FXML
    private Label following;

    private FXUITest fxuiTest;

    private UserVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        fxuiTest = fxui;

    }

    public void repaint() {
        name.setText(vo.getName());
        followers.setText(String.valueOf(vo.getFollowers()));
        following.setText(String.valueOf(vo.getFollowing()));

    }

    @FXML
    private void handleCheck(){
        fxuiTest.checkUser(vo);
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
