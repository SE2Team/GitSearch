package presentation.repoCheckui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import businesslogicService.StatisticsBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;
import vo.StaStrVO;

import java.io.IOException;
import java.util.ArrayList;

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
    private BarChart langChart;
    @FXML
    private CategoryAxis xLang;
    @FXML
    private NumberAxis ylang;
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

    private ObservableList<String> langs = FXCollections.observableArrayList();

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
//        StaStrVO staStrVO=bl.languagesOfRepository(username,reponame);
//        langs.addAll(bl.languagesOfRepository());
//        xLang.setCategories(langs);
//        langChart.getData().addAll(getdata());
    }

    private void setList() throws IOException {
        if (vo.getContributors() != null) {
            for (int i = 0; i < vo.getContributors().size(); i++) {
                contributorPane.getChildren().add(getSub(vo.getContributors().get(i)));
                /**
                 * 最多只能放7个+一个more
                 */
                if (i >= 6) {
                    contributorPane.getChildren().addAll(getSub("@more"));
                    break;
                }
            }
        }

        if (vo.getCollaborators() != null) {
            for (int i = 0; i < vo.getCollaborators().size(); i++) {
                collaboratorPane.getChildren().add(getSub(vo.getCollaborators().get(i)));
                /**
                 * 最多只能放7个+一个more
                 */
                if (i >= 6) {
                    collaboratorPane.getChildren().addAll(getSub("@more"));
                    break;
                }
            }
        }
    }

    @FXML
    public void initialize() {
//        xLang.setLabel("languages");
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
        this.vo = bl.checkRepository(username,reponame);
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


    }

    private ArrayList<String> getList() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("java");
        a.add("C#");
        a.add("html");
        a.add("ruby");
        a.add("python");
        return a;
    }

    private XYChart.Series<String, Integer> getdata() {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        for (int i = 0; i < 5; i++) {
            series.getData().add(new XYChart.Data<>(langs.get(i), i + 70));
        }

        return series;
    }
}
