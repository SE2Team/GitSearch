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
    //    @FXML
//    private Label following;
    @FXML
    private Label repos;

    private FXUITest fxuiTest;

    private UserVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        fxuiTest = fxui;

    }

    public void repaint() {
        String nameText = vo.getName() != "" ? vo.getName() : "Unknown";
        name.setText(nameText);
        followers.setText(String.valueOf(vo.getFollowers()));
        repos.setText(String.valueOf(vo.getPublic_repos()));
        id.setText(vo.getLogin());
//        repos.set(vo.getRepos());
    }

    @FXML
    private void handleCheck() {
        fxuiTest.checkUser(vo);
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
