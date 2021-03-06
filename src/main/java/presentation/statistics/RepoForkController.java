package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoForkController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Number> forkChart;
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

    public BarChart<String, Number> getForkChart() {
        return forkChart;
    }

    public void setForkChart(BarChart<String, Number> forkChart) {
        this.forkChart = forkChart;
    }
}
