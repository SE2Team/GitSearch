package presentation.repoCheckui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.RepositoryBL.StatisticsController;
import businesslogicService.RepositoryBLService;
import businesslogicService.StatisticsBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import org.kohsuke.github.GHCommit;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedIterable;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;
import vo.StaStrVO;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class CheckRepoController implements MyController {
    private FXUITest fxui;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label stars;
    @FXML
    private Label forks;
    @FXML
    private Label subscribers;
    @FXML
    private Label description;
    @FXML
    private Label reponame;

    @FXML
    private Label language;

    @FXML
    private FlowPane contributorPane;

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane commitPane;

    @FXML
    private BarChart poiChart;
    @FXML
    private PieChart langChart;
    @FXML
    private LineChart commitChart;
    @FXML
    private CategoryAxis xpoi;
    @FXML
    private Label owner;
    @FXML
    private AnchorPane noNetWork;
//    @FXML
//    private TextArea readMe;
    @FXML
    private WebView webInfo;

    private XYChart.Series seriesLang = new XYChart.Series<>();
    private RepositoryBLService bl = new RepositoryController();

    private boolean isChart = false;
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
        commitChart.setVisible(false);
        reponame.setText(vo.getName());
        description.setText(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers_count()));
        forks.setText(String.valueOf(vo.getForks()));
        subscribers.setText(String.valueOf(vo.getSubscribers_count()));

        language.setText(vo.getLanguage());
        try {
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            setCommitList();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] split = vo.getName().split("/");
        String username = split[0];
        String reponame = split[1];
        owner.setText(username);
//        try {
//            readMe.setText(vo.getReadMe().read().toString());
//        } catch (IOException e) {
//            System.out.println("界面层：ReaMe 获取失败！");
//
//        }
//        WebEngine webEngine=webInfo.getEngine();
//        webEngine.load(vo.getHtml_url().toExternalForm());

    }

    private void setList() throws IOException {
        Iterator<GHRepository.Contributor> itrcon = vo.getContributors().iterator();
        int i = 0;
        while (itrcon.hasNext()&& i++<9) {
            contributorPane.getChildren().add(getSub(itrcon.next()));
        }
    }

    private void setCommitList() throws IOException{
        Iterator<GHCommit> commit_Itr = vo.getDpo().listCommits().iterator();
        while (commit_Itr.hasNext()){
            commitPane.getChildren().add(getCommitSub(commit_Itr.next()));
        }
    }
    @FXML
    public void initialize() {
//        xpoi.setLabel("languages");
        seriesLang.setName("language");
//        sbl=new StatisticsController();

        yAxis.setAutoRanging(false);
        yAxis.setUpperBound(10);
        yAxis.setTickUnit(1);

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
//        setGraph();

    }

    @Deprecated
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

    /**
     * 展示贡献者login的小面板
     * @param contributor
     * @return
     * @throws IOException
     */
    public Parent getSub(GHRepository.Contributor contributor) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepCheckContri.fxml"));
        AnchorPane anchorPane = loader.load();
        SubContriController controller = loader.getController();

        controller.setFxui(fxui);
        controller.setText(contributor.getLogin());
        controller.repaint();
        return anchorPane;
    }

    /**
     * 获取commit信息的子面板
     * @param commit
     * @return
     * @throws IOException
     */
    public AnchorPane getCommitSub(GHCommit commit) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubCommit.fxml"));
        AnchorPane anchorPane = loader.load();
        SubCommitController controller = loader.getController();
        controller.setFxui(fxui);
        controller.setCommit(commit);
        controller.repaint();
        return anchorPane;
    }

    private void setGraph() {
        //---------------set language graph-------------
        try {
            staStrVO = bl.languagesOfRepository(vo);
            if (staStrVO.getX().size()!=0) {


                double sum = 0;
                for (int j = 0; j < staStrVO.getInt().size(); j++) {
                    sum += staStrVO.getInt().get(j);
                }
                double temp = 0;
                for (int i = 0; i < staStrVO.getInt().size() && i < staStrVO.getX().size() && i < 5; i++) {
                    temp += staStrVO.getInt().get(i);
                    langs.addAll(new PieChart.Data(staStrVO.getX().get(i), staStrVO.getInt().get(i)));
                    if (i==4){
                        langs.addAll(new PieChart.Data("Others", sum - temp));
                    }
                }
                langChart.setData(langs);
                noNetWork.setVisible(false);
            } else {
                langChart.setVisible(false);
                noNetWork.setVisible(true);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //---------------set point graph-------------

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
        for (int i = 0; i < vo.getInt().size() && i < vo.getX().size() && i < 500; i++) {
            if (vo.getX().get(vo.getX().size() - 1 - i).equalsIgnoreCase("Unknown")) {
                continue;
            }
            XYChart.Data<String,Integer> data=new XYChart.Data<String,Integer>(vo.getX().get(i), vo.getInt().get(i));
            data.nodeProperty().addListener(new ChangeListener<Node>() {
                @Override
                public void changed(ObservableValue<? extends Node> ov, Node oldNode, final Node node) {
                    if (node != null) {
//                        setNodeStyle(data);
                        displayLabelForData(data);
                    }
                }
            });
            series.getData().add(data);

        }
        observableList.add(series);
        return observableList;
    }

    /** places a text label with a bar's value above a bar node for a given XYChart.Data */
    private void displayLabelForData(XYChart.Data<String, Integer> data) {
        final Node node = data.getNode();
        final Text dataText = new Text(data.getYValue() + "");
        node.parentProperty().addListener(new ChangeListener<Parent>() {
            @Override public void changed(ObservableValue<? extends Parent> ov, Parent oldParent, Parent parent) {
                Group parentGroup = (Group) parent;
                parentGroup.getChildren().add(dataText);
            }
        });

        node.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
            @Override public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds) {
                dataText.setLayoutX(
                        Math.round(
                                bounds.getMinX() + bounds.getWidth() / 2 - dataText.prefWidth(-1) / 2
                        )
                );
                dataText.setLayoutY(
                        Math.round(
                                bounds.getMinY() - dataText.prefHeight(-1) * 0.5
                        )
                );
            }
        });
    }
    @FXML
    private void handleCommit(){
        if(isChart){
            isChart = false;
            commitChart.setVisible(false);
            scrollPane.setVisible(true);
            commitPane.setVisible(true);
        }else{
            isChart = true;
            scrollPane.setVisible(false);
            commitPane.setVisible(false);
            commitChart.setVisible(true);
        }
    }

}
