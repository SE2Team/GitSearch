package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoContriController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Number> contributorsChart;

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

    public BarChart<String, Number> getContributorsChart() {
        return contributorsChart;
    }

    public void setContributorsChart(BarChart<String, Number> contributorsChart) {
        this.contributorsChart = contributorsChart;
    }
}
