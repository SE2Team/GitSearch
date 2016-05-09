package presentation.common;

import javafx.fxml.FXML;
import presentation.FXUITest;

/**
 * Created by moeyui on 2016/3/15 0015.
 */
public interface MyController {

    /**
     * 构造方法，在绑定组件之前
     */
    @FXML
    void initialize();

    void setFxui(FXUITest fxui);

    void repaint();
}
