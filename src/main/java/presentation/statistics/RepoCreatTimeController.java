package presentation.statistics;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoCreatTimeController implements MyController {
    private FXUITest fxuiTest;
    @FXML
    private Label year;
    @FXML
    private Label num;
    @FXML
    private PieChart creatTimeChart;

    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    @Override
    public void repaint() {
        pieTxt(this.creatTimeChart);
    }

    public PieChart getCreatTimeChart() {
        return creatTimeChart;
    }

    public void setCreatTimeChart(PieChart creatTimeChart) {
        this.creatTimeChart = creatTimeChart;
    }

    private void pieTxt(PieChart pieChart) {
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
//        chartPane.getChildren().addAll(caption);
        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
//                            caption.setTranslateX(e.getSceneX());
//                            caption.setTranslateY(e.getSceneY());
                            num.setText(String.valueOf(data.getPieValue()));
                            year.setText(data.getName());
                        }
                    });
        }
    }
}
