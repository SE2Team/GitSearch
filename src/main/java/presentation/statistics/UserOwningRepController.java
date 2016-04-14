package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class UserOwningRepController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private LineChart OwnChart;
    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    @Override
    public void repaint() {

    }

    public LineChart getOwnChart() {
        return OwnChart;
    }

    public void setOwnChart(LineChart ownChart) {
        OwnChart = ownChart;
    }
}
