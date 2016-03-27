package presentation.searchui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/3/27 0027.
 */
public class testController implements MyController{
    @FXML
    public void initialize() {
        group.getToggles().addAll(t1,t2);
    }

    public void setFxui(FXUITest fxui) {

    }

    public void repaint() {
//        for ()
    }

    @FXML
    private ToggleGroup group=new ToggleGroup();
    @FXML
    private Button b1,b2;
    @FXML
    private ToggleButton t1;
    @FXML
    private ToggleButton t2;
    @FXML
    private AnchorPane anchorPane;



}
