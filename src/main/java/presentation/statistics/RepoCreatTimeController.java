package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoCreatTimeController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private Label year;
    @FXML
    private Label num;
    @FXML
    private PieChart creatTimeChart;
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

    public PieChart getCreatTimeChart() {
        return creatTimeChart;
    }

    public void setCreatTimeChart(PieChart creatTimeChart) {
        this.creatTimeChart = creatTimeChart;
    }
}
