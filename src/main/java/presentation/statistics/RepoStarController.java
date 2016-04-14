package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoStarController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Integer> starChart;
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

    public BarChart<String, Integer> getStarChart() {
        return starChart;
    }

    public void setStarChart(BarChart<String, Integer> starChart) {
        this.starChart = starChart;
    }
}
