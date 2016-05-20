package presentation.Trending;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

/**
 * Created by Administrator on 2016/5/4.
 */
public class SubUserTrendController implements MyController{
    @FXML
    private ImageView imageView;
    @FXML
    private Label name;
    @FXML
    private Label LogIn;
    @FXML
    private Label followers;
    @FXML
    private Label repos;

    private FXUITest fxuiTest;

    private UserVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {
        String nameText = vo.getName() != "" ? vo.getName() : "Unknown";
        name.setText(nameText);
        LogIn.setText(vo.getLogin());
        followers.setText(String.valueOf(vo.getFollowers()));
        repos.setText(String.valueOf(vo.getPublic_repos()));
        imageView.setImage(vo.getUserImage());
    }

    @FXML
    private void handleCheck() {
        fxuiTest.checkUser(vo);
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }
}
