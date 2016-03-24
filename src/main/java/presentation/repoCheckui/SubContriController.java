package presentation.repoCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/3/24 0024.
 */
public class SubContriController implements MyController{
    @FXML
    private Label label;
    @FXML
    private ImageView imageView;

    @FXML
    private FXUITest fxuiTest;
    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    public void repaint() {

    }

    public void setText(String str){
        this.label.setText(str);
    }

    public void setMore(){
        this.label.setText("More...");
        imageView.setVisible(false);
    }
}
