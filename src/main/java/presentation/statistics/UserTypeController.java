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
public class UserTypeController implements MyController{
    private FXUITest fxuiTest;
    @FXML
    private Label type;
    @FXML
    private Label num;
    @FXML
    private PieChart typeChart;

    @Override
    public void initialize() {
//        type.setText(typeChart.getData());
    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    @Override
    public void repaint() {
        pieTxt(this.typeChart);
    }


    public PieChart getTypeChart() {
        return typeChart;
    }

    public void setTypeChart(PieChart typeChart) {
        this.typeChart = typeChart;
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
                            type.setText(data.getName());
                        }
                    });
        }
    }
}
