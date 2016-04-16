package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.AnchorPane;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoLanController implements MyController {
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String, Number> langChart;
    @FXML
    private AnchorPane mom;

    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    @Override
    public void repaint() {

    }

    public BarChart<String, Number> getLangChart() {
        return langChart;
    }

    public void setLangChart(BarChart<String, Number> langChart) {
        this.langChart = langChart;
    }


}
