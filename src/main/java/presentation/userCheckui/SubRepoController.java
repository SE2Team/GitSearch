package presentation.userCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/3/25 0025.
 */
public class SubRepoController implements MyController {

    @FXML
    private Label label;
    @FXML
    private ImageView imageView;


    public FXUITest fxuiTest;
    public void initialize() {
    }

    public void setFxui(FXUITest fxui) {
        fxuiTest=fxui;
        fxuiTest.push();
    }

    public void repaint() {

    }
    public void setText(String str){
        if(str=="@more"){
            setMore();
            return;
        }
        this.label.setText(str);
    }

    public void setMore(){
        this.label.setText("More...");
        imageView.setVisible(false);
    }

}
