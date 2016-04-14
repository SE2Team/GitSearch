package presentation.repoCheckui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.RepositoryBLService;
import businesslogicService.StatisticsBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;
import vo.StaStrVO;
import vo.StatisticsVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class CheckRepoController implements MyController {
    private FXUITest fxui;
    @FXML
    private Label stars;
    @FXML
    private Label forks;
    @FXML
    private Label contributors;
    @FXML
    private Label subscribers;
    @FXML
    private Label collaborator;
    @FXML
    private Label description;
    @FXML
    private Label reponame;

    @FXML
    private Label language;

    @FXML
    private FlowPane contributorPane;

    @FXML
    private FlowPane collaboratorPane;

    @FXML
    private BarChart poiChart;
    @FXML
    private PieChart langChart;
    @FXML
    private CategoryAxis xpoi;
    @FXML
    private NumberAxis ypoi;
    @FXML
    private Label owner;

    private XYChart.Series seriesLang = new XYChart.Series<>();
    private RepositoryBLService bl = new RepositoryController();


//    @FXML
//    private Tab conTab;
//
//    @FXML
//    private Tab colTab;


    private RepositoryVO vo;
    private StaStrVO staStrVO;

    private ObservableList<PieChart.Data> langs = FXCollections.observableArrayList();
    private ObservableList<String> pois = FXCollections.observableArrayList();

    private StatisticsBLService sbl;


    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;

    }

    public void repaint() {
        if (vo == null) {
            return;
        }
        reponame.setText(vo.getName());
        description.setText(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers()));
        forks.setText(String.valueOf(vo.getForks()));
        subscribers.setText(String.valueOf(vo.getSubscribers_count()));
        collaborator.setText(String.valueOf(vo.getContributor()));
        contributors.setText(String.valueOf(vo.getContributor()));
        language.setText(vo.getLanguage());
        try {
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] split = vo.getName().split("/");
        String username = split[0];
        String reponame = split[1];
        owner.setText(username);
        setGraph();

    }

    private void setList() throws IOException {
        if (vo.getContributors() != null) {
            for (int i = 0; i < vo.getContributors().size(); i++) {

                contributorPane.getChildren().add(getSub(vo.getContributors().get(i)));
                /**
                 * 最多只能放7个+一个more
                 */
//                if (i >= 6) {
//                    contributorPane.getChildren().addAll(getSub("@more"));
//                    break;
//                }
            }
        }

        if (vo.getCollaborators() != null) {
            for (int i = 0; i < vo.getCollaborators().size(); i++) {
                collaboratorPane.getChildren().add(getSub(vo.getCollaborators().get(i)));
                /**
                 * 最多只能放7个+一个more
                 */
//                if (i >= 6) {
//                    collaboratorPane.getChildren().addAll(getSub("@more"));
//                    break;
//                }
            }
        }
    }

    @FXML
    public void initialize() {
//        xpoi.setLabel("languages");
        seriesLang.setName("language");
//        sbl=new StatisticsController();
    }

    /**
     * get vo with arrays
     *
     * @param vo
     */
    public void setVo(RepositoryVO vo) throws IOException {
        String[] split = vo.getName().split("/");
        String username = split[0];
        String reponame = split[1];
        this.vo = bl.checkRepository(username, reponame);
    }

    public Parent getSub(String str) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepCheckContri.fxml"));
        AnchorPane anchorPane = loader.load();
        SubContriController controller = loader.getController();

        controller.setFxui(fxui);
        controller.setText(str);
        controller.repaint();
        return anchorPane;
    }

    private void setGraph() {
        //---------------set language graph-------------
        try {
            staStrVO = bl.languagesOfRepository(vo.getOwnerName(), vo.getRepoName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        double sum = 0;
        for (int j = 0; j < staStrVO.getInt().size(); j++) {
            sum += staStrVO.getInt().get(j);
        }
        double temp = 0;
        for (int i = 0; i < staStrVO.getInt().size() && i < staStrVO.getStr().size() && i < 5; i++) {
            temp += staStrVO.getInt().get(i);
            langs.addAll(new PieChart.Data(staStrVO.getStr().get(i), staStrVO.getInt().get(i)));
            if (i==4){
                langs.addAll(new PieChart.Data("Others", sum - temp));
            }
        }
        langChart.setData(langs);
        //---------------set point graph

//        langs.addAll(bl.languagesOfRepository());
//        xpoi.setCategories(langs);
//        poiChart.getData().addAll(getdata());
        StatisticsBLService sbl=new StatisticsController();
        try {
            poiChart.setData(getData(sbl.getScores(vo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ObservableList<XYChart.Series<String, Integer>> getData(StaStrVO vo) {
        ObservableList<XYChart.Series<String, Integer>> observableList = FXCollections.observableArrayList();
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        for (int i = 0; i < vo.getInt().size() && i < vo.getStr().size() && i < 500; i++) {
            if (vo.getStr().get(vo.getStr().size() - 1 - i).equalsIgnoreCase("Unknown")) {
                continue;
            }
            series.getData().add(new XYChart.Data<>(vo.getStr().get(i), vo.getInt().get(i)));

        }
        observableList.add(series);
        return observableList;
    }

}
