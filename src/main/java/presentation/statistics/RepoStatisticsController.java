package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.chart.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.StaStrVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/16 0016.
 */
public class RepoStatisticsController implements MyController {
    private FXUITest fxuiTest;
    private StatisticsBLService bl = new StatisticsController();

    @FXML
    private ComboBox chartType;

    @FXML
    private BarChart<String, Integer> langChart;
    @FXML
    private PieChart creatTimeChart;
    @FXML
    private BarChart<String, Integer> forkChart;
    @FXML
    private BarChart<String, Integer> starChart;
    @FXML
    private LineChart<String, Integer> contributorsChart;
    @FXML
    private LineChart<String, Integer> collaboratorsChart;
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
        chartType.getItems().clear();
        chartType.getItems().addAll("Language", "Create Time", "Fork", "Star", "Contributors", "Collaborators");
        chartType.getSelectionModel().selectFirst();
        handleChange();
    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {

    }

    private ObservableList<XYChart.Series<String, Integer>> getData(StaStrVO vo) {
        return getData(vo, true);
    }

    private ObservableList<XYChart.Series<String, Integer>> getData(StaStrVO vo, Boolean b) {
        ObservableList<XYChart.Series<String, Integer>> observableList = FXCollections.observableArrayList();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < vo.getInt().size() && i < vo.getStr().size() && i < 500; i++) {
            if (vo.getStr().get(vo.getStr().size() - 1 - i).equalsIgnoreCase("Unknown")) {
                continue;
            }
            series.getData().add(new XYChart.Data<>(vo.getStr().get(i), vo.getInt().get(i)));
            if (i == 9 && b) {
                series = addOthers(series, vo.getSum(10));
            }
        }
        observableList.add(series);
        return observableList;
    }

    private ObservableList<PieChart.Data> getPieData(StaStrVO vo) {
        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (int i = 0; i < vo.getStr().size() && i < vo.getInt().size() && i < 7; i++) {
            observableList.add(new PieChart.Data(vo.getStr().get(i), vo.getInt().get(i)));
            if (i == 6) {
                observableList.add(new PieChart.Data("Others", vo.getSum()));
            }
        }
        return observableList;
    }

    private XYChart.Series addOthers(XYChart.Series series, Integer i) {
        series.getData().add(new XYChart.Data<>("Others", i));
        return series;
    }

    @FXML
    private void handleChange() {
        chartPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        String str = "";
        AnchorPane anchorPane=new AnchorPane();

        try {
            switch (chartType.getSelectionModel().getSelectedItem().toString()) {
                case "Language":
                    str = "RepoLan.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    RepoLanController controller = loader.getController();
                    controller.getLangChart().setData(getData(bl.getLanguage()));
                    break;
                case "Create Time":
                    str = "RepoCreateTime.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    RepoCreatTimeController repoCreatTimeController = loader.getController();
                    repoCreatTimeController.getCreatTimeChart().setData(getPieData(bl.getRepoCreated()));
                    pieTxt(repoCreatTimeController.getCreatTimeChart());
                    setupAnimation(repoCreatTimeController.getCreatTimeChart().getData());

                    break;
                case "Fork":
                    str = "RepoFork.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);

                    RepoForkController repoForkController = loader.getController();
                    repoForkController.getForkChart().setData(getData(bl.getForks()));
                    break;
                case "Star":
                    str = "RepoStar.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);

                    RepoStarController repoStarController = loader.getController();
                    repoStarController.getStarChart().setData(getData(bl.getStar()));
                    break;
                case "Contributors":
                    str = "RepoContri.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);

                    RepoContriController repoContriController = loader.getController();
                    repoContriController.getContributorsChart().setData(getData(bl.getContributor()));
//                    ObservableList<XYChart.Series<String, Integer>> data=getData(bl.getContributor());
//
//                    for(int i=0;i<data.size();i++){
//                        data.get(i).setNode(new HoveredThresholdNode(0,));
//                    }

                    break;
                case "Collaborators":
                    str = "RepoColla.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);

                    RepoCollaController repoCollaController = loader.getController();
                    repoCollaController.getCollaboratorsChart().setData(getData(bl.getCollaborator()));
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void pieTxt(PieChart pieChart){
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
        chartPane.getChildren().addAll(caption);
        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
//                            caption.setTranslateX(e.getSceneX());
//                            caption.setTranslateY(e.getSceneY());
                            caption.setLayoutX(e.getSceneX());
                            caption.setLayoutX(e.getSceneY());

                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
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
}
