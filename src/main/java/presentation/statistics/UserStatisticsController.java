package presentation.statistics;

import businesslogicService.StatisticsBLService;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/9 0009.
 */
public class UserStatisticsController implements MyController{
    FXUITest fxuiTest;
    private StatisticsBLService bl;

    @FXML
    private PieChart typeChart;
    @FXML
    private BarChart<String,Integer> creatTimeChart;
    @FXML
    private LineChart relatedChart;
    @FXML
    private LineChart OwnChart;
    @FXML
    private BarChart<String,Integer> companyChart;
    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {

    }

    @Override
    public void repaint() {

    }
}
