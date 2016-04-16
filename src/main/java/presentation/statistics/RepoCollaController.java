package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoCollaController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Integer> collaboratorsChart;
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

    public BarChart<String, Integer> getCollaboratorsChart() {
        return collaboratorsChart;
    }

    public void setCollaboratorsChart(BarChart<String, Integer> collaboratorsChart) {
        this.collaboratorsChart = collaboratorsChart;
    }
}
