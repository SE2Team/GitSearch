package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.StaIntVO;
import vo.StaStrVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/4/9 0009.
 */
public class UserStatisticsController implements MyController {
    FXUITest fxuiTest;
    private StatisticsBLService bl;

    @FXML
    private PieChart typeChart;
    @FXML
    private BarChart<String, Integer> creatTimeChart;
    @FXML
    private LineChart relatedChart;
    @FXML
    private LineChart OwnChart;
    @FXML
    private BarChart<String, Integer> companyChart;

    @Override
    public void initialize() {
        bl = new StatisticsController();
        try {
            typeChart.setData(getPieData(bl.getUserType()));
            creatTimeChart.setData(getData(bl.getUserCreated()));
            relatedChart.setData(getData(bl.getUserRelated()));
            OwnChart.setData(getData(bl.getUserHas()));
            companyChart.setData(getData(bl.getCompany()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    @Override
    public void repaint() {

    }

    private ObservableList<PieChart.Data> getPieData(StaStrVO vo) {
        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (int i = 0; i < vo.getStr().size() && i < vo.getInt().size() && i < 7; i++) {
            observableList.addAll(new PieChart.Data(vo.getStr().get(i), vo.getInt().get(i)));
            if (i == 6) {
                observableList.addAll(new PieChart.Data("Others", vo.getSum()));
            }
        }
        return observableList;
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaStrVO vo){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getStr().size()&&i<10;i++){

            series.getData().add(new XYChart.Data<>(vo.getStr().get(i),vo.getInt().get(i)));
            if(i==9){
                series.getData().add(new XYChart.Data<>("Others",vo.getSum(10)));
            }
        }
        observableList.add(series);
        return observableList;
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaIntVO vo){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getInt2().size()&&i<10;i++){

            series.getData().add(new XYChart.Data<>(String.valueOf(vo.getInt2().get(i)),vo.getInt().get(i)));
            if(i==9){
                series.getData().add(new XYChart.Data<>("Others",vo.getSum(10)));
            }
        }
        observableList.add(series);
        return observableList;
    }
}
