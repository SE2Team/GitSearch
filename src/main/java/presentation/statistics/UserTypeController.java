package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class UserTypeController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private PieChart typeChart;
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

    public PieChart getTypeChart() {
        return typeChart;
    }

    public void setTypeChart(PieChart typeChart) {
        this.typeChart = typeChart;
    }
}
