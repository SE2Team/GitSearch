package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.StaIntVO;
import vo.StaStrVO;

import java.io.IOException;
import java.util.function.Consumer;

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
                    setupAnimation(userTypeController.getTypeChart().getData());
                    userTypeController.repaint();
                    break;
                case "Create Time":
                    loader.setLocation(this.getClass().getResource("UserCreateTime.fxml"));
                    anchorPane=loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    UserCreateTimeController userCreateTimeController=loader.getController();
                    userCreateTimeController.getCreatTimeChart().setData(getData(bl.getUserCreated()));
//                    setupBarAnimation(userCreateTimeController.getCreatTimeChart().getData());
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
    /**
     * 很带感的饼状图互动
     * @param pcData
     */
    private void setupAnimation(ObservableList<PieChart.Data> pcData) {
        pcData.stream().forEach(pieData -> {
//            System.out.println(pieData.getName() + ": " + pieData.getPieValue());
            pieData.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Bounds b1 = pieData.getNode().getBoundsInLocal();
                    double newX = (b1.getWidth()) / 2 + b1.getMinX();
                    double newY = (b1.getHeight()) / 2 + b1.getMinY();
                    // Make sure pie wedge location is reset
                    pieData.getNode().setTranslateX(0);
                    pieData.getNode().setTranslateY(0);

                    // Show the BoundsInLocal of the selected wedge with a rectangle
//                rectangle.setTranslateX(newX);
//                rectangle.setTranslateY(newY);
//                rectangle.setWidth(b1.getWidth());
//                rectangle.setHeight(b1.getHeight());

                    // Create the animation
                    TranslateTransition tt = new TranslateTransition(
                            Duration.millis(1500), pieData.getNode());
                    tt.setByX(newX);
                    tt.setByY(newY);
                    tt.setAutoReverse(true);
                    tt.setCycleCount(2);
                    tt.play();
                }
            });
        });
    }
    /**
     * 很带感的柱状图互动
     * @param pcData
     */
    private void setupBarAnimation(ObservableList<XYChart.Series<String,Integer>> pcData) {
        pcData.stream().forEach(new Consumer<XYChart.Series<String, Integer>>() {
            @Override
            public void accept(XYChart.Series<String, Integer> pieData) {
                pieData.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Bounds b1 = pieData.getNode().getBoundsInLocal();
                        double newX = (b1.getWidth()) / 2 + b1.getMinX();
                        double newY = (b1.getHeight()) / 2 + b1.getMinY();
                        // Make sure pie wedge location is reset
                        pieData.getNode().setTranslateX(0);
                        pieData.getNode().setTranslateY(0);

                        // Show the BoundsInLocal of the selected wedge with a rectangle
//                rectangle.setTranslateX(newX);
//                rectangle.setTranslateY(newY);
//                rectangle.setWidth(b1.getWidth());
//                rectangle.setHeight(b1.getHeight());

                        // Create the animation
                        TranslateTransition tt = new TranslateTransition(
                                Duration.millis(1500), pieData.getNode());
                        tt.setByX(newX);
                        tt.setByY(newY);
                        tt.setAutoReverse(true);
                        tt.setCycleCount(2);
                        tt.play();
                    }
                });
            }
        });
    }
}