package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoLanController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Integer> langChart;
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

    public BarChart<String, Integer> getLangChart() {
        return langChart;
    }

    public void setLangChart(BarChart<String, Integer> langChart) {
        this.langChart = langChart;
    }
}
