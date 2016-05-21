package presentation.statistics;

import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.StatisticsBLService;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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
        chartType.getItems().addAll("Language", "Create Time", "Fork", "Star");
        chartType.getSelectionModel().selectFirst();
        handleChange();
    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {

    }

    private ObservableList<XYChart.Series<String, Number>> getData(StaStrVO vo) {
        return getData(vo, true);
    }

    private ObservableList<XYChart.Series<String, Number>> getData(StaStrVO vo, Boolean b) {
        ObservableList<XYChart.Series<String, Number>> observableList = FXCollections.observableArrayList();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (int i = 0; i < vo.getInt().size() && i < vo.getX().size() && i < 20; i++) {
            if (vo.getX().get(vo.getX().size() - 1 - i).equalsIgnoreCase("Unknown")) {
                continue;
            }
            /**
             * 添加互动和文字
             */
            XYChart.Data<String, Number> data = new XYChart.Data<>(vo.getX().get(i), vo.getInt().get(i));
            data.nodeProperty().addListener(new ChangeListener<Node>() {
                @Override
                public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
                    if (node != null) {
                        displayLabelForData(data);
                    }
                }
            });
            series.getData().add(data);
            if (i == 19 && b) {
                series = addOthers(series, vo.getSum(10));
            }
        }
        observableList.add(series);
        return observableList;
    }

    /**
     * 在柱状图上显示数字并添加鼠标互动事件
     * @param data
     */
    private void displayLabelForData(XYChart.Data<String, Number> data) {
        final Node node = data.getNode();
        final Text dataText = new Text(data.getYValue() + "");
        node.parentProperty().addListener(new ChangeListener<Parent>() {
            @Override
            public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
                Group parentGroup = (Group) parent;
                parentGroup.getChildren().add(dataText);
            }
        });

        node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                dataText.setLayoutX(
                        Math.round(
                                bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
                        )
                );
                dataText.setLayoutY(
                        Math.round(
                                bounds.getMinY() //+ dataText.prefHeight(-1) * 0.5
                        )
                );
            }
        });

        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               data.getNode().setStyle(
                       "-fx-cursor: hand; -fx-border-width: 3;-fx-border-color: gray;");

            }
        });
        data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                data.getNode().setStyle("");
            }
        });

    }

    private ObservableList<PieChart.Data> getPieData(StaStrVO vo) {
        ObservableList<PieChart.Data> observableList = FXCollections.observableArrayList();
        for (int i = 0; i < vo.getX().size() && i < vo.getInt().size() && i < 7; i++) {
            observableList.add(new PieChart.Data(vo.getX().get(i), vo.getInt().get(i)));
            if (i == 6) {
                observableList.add(new PieChart.Data("Others", vo.getSum()));
            }
        }
        return observableList;
    }

    private XYChart.Series addOthers(XYChart.Series series, Number i) {
        XYChart.Data<String, Number> data = new XYChart.Data<>("Others", i);
        data.nodeProperty().addListener(new ChangeListener<Node>() {
            @Override
            public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
                if (node != null) {
                    displayLabelForData(data);
                }
            }
        });
        series.getData().add(data);
        return series;
    }

    @FXML
    private void handleChange() {
        chartPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        String str = "";
        AnchorPane anchorPane = new AnchorPane();

        try {
            switch (chartType.getSelectionModel().getSelectedItem().toString()) {
                case "Language":
                    str = "RepoLan.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    RepoLanController controller = loader.getController();
                    controller.getLangChart().setData(getData(bl.getLanguage()));

                    controller.repaint();
                    break;
                case "Create Time":
                    str = "RepoCreateTime.fxml";
                    loader.setLocation(this.getClass().getResource(str));
                    anchorPane = loader.load();
                    chartPane.getChildren().addAll(anchorPane);
                    RepoCreatTimeController repoCreatTimeController = loader.getController();
                    repoCreatTimeController.getCreatTimeChart().setData(getPieData(bl.getRepoCreated()));
                    setupAnimation(repoCreatTimeController.getCreatTimeChart().getData());
                    repoCreatTimeController.repaint();

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


    /**
     * 很带感的饼状图互动
     *
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
     *
     */
    private void setupAnimation(XYChart<String, Number> xyChart) {
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(500),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                for (XYChart.Series<String, Number> series : xyChart.getData()) {
                                    for (XYChart.Data<String, Number> data : series.getData()) {
                                        data.setXValue(String.valueOf(Math.random() * 1000));
                                    }
                                }
                            }
                        }
                ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();
    }


}
