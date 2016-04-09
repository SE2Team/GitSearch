package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.StaStrVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/16 0016.
 */
public class RepoStatisticsController implements MyController {
    FXUITest fxuiTest;
    private StatisticsBLService bl;

    @FXML
    private BarChart<String,Integer> langChart;
    @FXML
    private PieChart creatTimeChart;
    @FXML
    private BarChart<String,Integer> forkChart;
    @FXML
    private BarChart<String,Integer> starChart;
    @FXML
    private BarChart<String,Integer> contributorsChart;
    @FXML
    private BarChart<String,Integer> collaboratorsChart;
    @FXML
    private CategoryAxis xlang;


    public void initialize() {
        bl=new StatisticsController();
        try {
            langChart.setData(getData(bl.getLanguage()));
            creatTimeChart.setData(getPieData(bl.getRepoCreated()));
            forkChart.setData(getData(bl.getForks()));
            starChart.setData(getData(bl.getStar()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    public void repaint() {

    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaStrVO vo){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getStr().size()&&i<8;i++){

            series.getData().add(new XYChart.Data<>(vo.getStr().get(i),vo.getInt().get(i)));
            if(i==7){
                series.getData().add(new XYChart.Data<>("Others",vo.getSum(8)));
            }
        }
        observableList.add(series);
        return observableList;
    }

    private ObservableList<PieChart.Data> getPieData(StaStrVO vo){
        ObservableList<PieChart.Data> observableList=FXCollections.observableArrayList();
        for (int i=0;i<vo.getStr().size()&&i<vo.getInt().size()&&i<7;i++){
            observableList.addAll(new PieChart.Data(vo.getStr().get(i),vo.getInt().get(i)));
            if(i==6){
                observableList.addAll(new PieChart.Data("Others",vo.getSum()));
            }
        }
        return observableList;
    }




}
