package presentation.repoCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

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
            UserVO vo=bl.CheckUser(this.label.getText());
            if (vo!=null) {
                fxuiTest.checkUser();
            }else{
                Tooltip tooltip=new Tooltip("啊咧？你没有网络啊？没有网络查不到这个用户哦~");
                label.setTooltip(tooltip);
//                tooltip.setAutoHide(false);
//                tooltip.setAutoFix(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
