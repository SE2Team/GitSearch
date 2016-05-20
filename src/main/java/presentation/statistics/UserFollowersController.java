package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by Administrator on 2016/5/20.
 */
public class UserFollowersController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String,Number> FollowerChart;

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

    public BarChart<String,Number> getFollowerChart(){return FollowerChart;}
    public void setFollowerChart(BarChart<String, Number> FollowerChart) {
        this.FollowerChart = FollowerChart;
    }

}
