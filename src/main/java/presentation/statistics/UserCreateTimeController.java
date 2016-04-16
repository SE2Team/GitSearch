package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class UserCreateTimeController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String, Number> creatTimeChart;
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

    public BarChart<String, Number> getCreatTimeChart() {
        return creatTimeChart;
    }

    public void setCreatTimeChart(BarChart<String, Number> creatTimeChart) {
        this.creatTimeChart = creatTimeChart;
    }
}
