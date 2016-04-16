package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class UserCompanyController implements MyController{
    private FXUITest fxuiTest;

    @FXML
    private BarChart<String, Integer> companyChart;
    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {

    }

    @Override
    public void repaint() {

    }

    public BarChart<String, Integer> getCompanyChart() {
        return companyChart;
    }

    public void setCompanyChart(BarChart<String, Integer> companyChart) {
        this.companyChart = companyChart;
    }
}
