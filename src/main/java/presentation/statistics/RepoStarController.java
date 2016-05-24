package presentation.statistics;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/4/13 0013.
 */
public class RepoStarController implements MyController {
    private FXUITest fxuiTest;
    @FXML
    private BarChart<String, Number> starChart;
    @FXML
    private WebView chart;
    @FXML
    private Button button;

    private WebEngine engine;
    String str = "{labels: [\"Red\", \"Blue\", \"Yellow\", \"Green\", \"Purple\", \"Orange\"],\n" +
            "\n" +
            "        }";
    @Override
    public void initialize() {
        engine = chart.getEngine();
        engine.load(this.getClass().getResource("../../RepoStar.html").toExternalForm());


    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    @Override
    public void repaint() {


    }

    public BarChart<String, Number> getStarChart() {
        return starChart;
    }

    public void setStarChart(BarChart<String, Number> starChart) {
        this.starChart = starChart;
    }

    @FXML
    private void handle() {
        String str[]={"a","b","c"};
        engine.executeScript("setData("+"[\"a\",\"b\",\"c\"]"+");");
    }
}
