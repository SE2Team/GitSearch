package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class UserRelatedRepController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private LineChart relatedChart;
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

    public LineChart getRelatedChart() {
        return relatedChart;
    }

    public void setRelatedChart(LineChart relatedChart) {
        this.relatedChart = relatedChart;
    }
}
