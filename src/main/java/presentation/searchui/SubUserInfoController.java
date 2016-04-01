package presentation.searchui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;

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
        String nameText=vo.getName()!=""?vo.getName():"Unknown";
        name.setText(nameText);
        followers.setText(String.valueOf(vo.getFollowers()));
        try {
            repos.setText(String.valueOf(vo.getHasNum()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        id.setText(vo.getLogin());
//        repos.setText(vo.getRepos());
    }

    @FXML
    private void handleCheck(){
        fxuiTest.checkUser(vo);
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
