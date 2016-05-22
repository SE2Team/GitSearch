package presentation.userCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import org.kohsuke.github.GHUser;
import presentation.FXUITest;
import presentation.common.MyController;

import java.io.IOException;

/**
 * Created by moeyui on 2016/5/21 0021.
 */
public class SubUserController implements MyController {
    @FXML
    private ImageView avatar;
    @FXML
    private Label username;
    @FXML
    private Label login;
    private FXUITest fxui;
    private UserBLService bl;
    @FXML
    private Tooltip fullName;
    @Override
    public void initialize() {
        bl=new UserController();
    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxui=fxui;
    }

    @Override
    public void repaint() {

    }
    public void set(GHUser user) throws IOException {
        this.avatar=new ImageView(user.getAvatarUrl());
        this.username.setText(user.getName());
        fullName.setText(user.getLogin());
        this.login.setText(user.getLogin());
    }
    @FXML
    private void check() throws IOException {
        fxui.checkUser(bl.CheckUser(login.getText()));
    }
}
