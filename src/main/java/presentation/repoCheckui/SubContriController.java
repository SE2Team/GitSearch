package presentation.repoCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/24 0024.
 */
public class SubContriController implements MyController{
    @FXML
    private Label label;
    @FXML
    private ImageView imageView;

    private UserBLService bl=new UserController();

    private FXUITest fxuiTest;
    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    public void repaint() {

    }

    public void setText(String str){
        if(str=="@more"){
            setMore();
            return;
        }
        /**
         * 去掉双引号
         */
        this.label.setText(str.replace("\"",""));
    }

    public void setMore(){
        this.label.setText("More...");
        imageView.setVisible(false);
    }

    @FXML
    private void handleCheck(){
        try {
            fxuiTest.checkUser(bl.CheckUser(this.label.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
