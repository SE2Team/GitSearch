package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.StaStrVO;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by moeyui on 2016/3/16 0016.
 */
public class RepoStatisticsController implements MyController {
    private FXUITest fxuiTest;
    private StatisticsBLService bl=new StatisticsController();
    @FXML
    private ComboBox chartType;
    @FXML
    private TabPane tabPane;
    @FXML
    private BarChart<String,Integer> langChart;
    @FXML
    private PieChart creatTimeChart;
    @FXML
    private BarChart<String,Integer> forkChart;
    @FXML
    private BarChart<String,Integer> starChart;
    @FXML
    private LineChart<String,Integer> contributorsChart;
    @FXML
    private LineChart<String,Integer> collaboratorsChart;
    @FXML
    private CategoryAxis xlang;
    @FXML
    private AnchorPane chartPane;




    public void initialize() {
//        try {
//            langChart.setData(getData(bl.getLanguage()));
//            creatTimeChart.setData(getPieData(bl.getRepoCreated()));
//            forkChart.setData(getData(bl.getForks()));
//            starChart.setData(getData(bl.getStar()));
//            contributorsChart.setData(getData(bl.getContributor(),false));
//            collaboratorsChart.setData(getData(bl.getCollaborator(),false));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        /**
         * 第一个表格淡入淡出
         */
//        FadeTransition ft=new FadeTransition(javafx.util.Duration.millis(2000),langChart);
//        ft.setFromValue(0.05);
//        ft.setToValue(1.0);
//        ft.setCycleCount(0);
//        ft.setAutoReverse(true);
//        ft.play();


    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    public void repaint() {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("RepoLan.fxml"));
        try {
            AnchorPane anchorPane=loader.load();
            RepoLanController controller=loader.getController();
            controller.getLangChart().setData(getData(bl.getLanguage()));
            chartPane.getChildren().addAll(anchorPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaStrVO vo){
        return getData(vo,true);
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaStrVO vo,Boolean b){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getStr().size()&&i<500;i++){
            if (vo.getStr().get(vo.getStr().size()-1-i).equalsIgnoreCase("Unknown")){
                continue;
            }
            series.getData().add(new XYChart.Data<>(vo.getStr().get(i),vo.getInt().get(i)));
            if(i==9&&b){
                series=addOthers(series,vo.getSum(10));
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

    private XYChart.Series addOthers(XYChart.Series series,Integer i){
        series.getData().add(new XYChart.Data<>("Others",i));
        return series;
    }

    @FXML
    private void handleTab(){
        try {
            switch (tabPane.getSelectionModel().getSelectedIndex()){
                case 0:
//                    if (langChart.getData().size()==0) {
                        langChart.setData(getData(bl.getLanguage()));
//                    }
                    break;
                case 1:
//                    if(creatTimeChart.getData().isEmpty()) {
                        creatTimeChart.setData(getPieData(bl.getRepoCreated()));
//                    }
                    break;
                case 2:
//                    if(forkChart.getData().isEmpty()){
                        forkChart.setData(getData(bl.getForks()));
//                    }
                    break;
                case 3:
//                    if (starChart.getData().isEmpty()){
                        starChart.setData(getData(bl.getStar()));
//                    }
                    break;
                case 4:
//                    if(contributorsChart.getData().isEmpty()) {
                        contributorsChart.setData(getData(bl.getContributor(), false));
//                    }
                    break;
                case 5:
//                    if (collaboratorsChart.getData().isEmpty()){
                        collaboratorsChart.setData(getData(bl.getCollaborator(),false));
//                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
