package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane chartPane;
    @FXML
    private ComboBox chartType;

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
//        try {
//            typeChart.setData(getPieData(bl.getUserType()));
//            creatTimeChart.setData(getData(bl.getUserCreated()));
//            relatedChart.setData(getData(bl.getUserRelated()));
//            OwnChart.setData(getData(bl.getUserHas()));
//            companyChart.setData(getData(bl.getCompany(),false));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        chartType.getItems().clear();
        chartType.getItems().addAll("User Type", "Create Time", "Related Repositories", "Owning Repositories", "Company");
        chartType.getSelectionModel().selectFirst();
        handleChange();
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
        return getData(vo,true);
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaStrVO vo,Boolean b){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getStr().size()&&i<10;i++){
            if (vo.getStr().get(i).equalsIgnoreCase("Unknown")){
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
    private ObservableList<XYChart.Series<String,Integer>> getData(StaIntVO vo){
        return getData(vo,true);
    }
    private ObservableList<XYChart.Series<String,Integer>> getData(StaIntVO vo,Boolean b){
        ObservableList<XYChart.Series<String,Integer>> observableList= FXCollections.observableArrayList();
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        for (int i=0;i<vo.getInt().size()&&i<vo.getInt2().size()&&i<10;i++){

            series.getData().add(new XYChart.Data<>(String.valueOf(vo.getInt().get(i)),vo.getInt2().get(i)));
            if(i==9&&b){
                series=addOthers(series,vo.getSum(10));
            }
        }
        observableList.add(series);
        return observableList;
    }

    private XYChart.Series addOthers(XYChart.Series series,Integer i){
        series.getData().add(new XYChart.Data<>("Others",i));
        return series;
    }
    @FXML
    private void handleChange() {
        chartPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        AnchorPane anchorPane=new AnchorPane();
        try {
            switch (chartType.getSelectionModel().getSelectedItem().toString()){
                case "User Type":
                    loader.setLocation(this.getClass().getResource("UserType.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserTypeController userTypeController=loader.getController();
                    userTypeController.getTypeChart().setData(getPieData(bl.getUserType()));
                    break;
                case "Create Time":
                    loader.setLocation(this.getClass().getResource("UserCreateTime.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserCreateTimeController userCreateTimeController=loader.getController();
                    userCreateTimeController.getCreatTimeChart().setData(getData(bl.getUserCreated()));
                    break;
                case "Related Repositories":
                    loader.setLocation(this.getClass().getResource("UserRelatedRep.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserRelatedRepController userRelatedRepController=loader.getController();
                    userRelatedRepController.getRelatedChart().setData(getData(bl.getUserRelated()));
                    break;
                case "Owning Repositories":
                    loader.setLocation(this.getClass().getResource("UserOwningRep.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserOwningRepController userOwningRepController=loader.getController();
                    userOwningRepController.getOwnChart().setData(getData(bl.getUserHas()));
                    break;
                case "Company":
                    loader.setLocation(this.getClass().getResource("UserCompany.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserCompanyController userCompanyController=loader.getController();
                    userCompanyController.getCompanyChart().setData(getData(bl.getCompany(),false));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
