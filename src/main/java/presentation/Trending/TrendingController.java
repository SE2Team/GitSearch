package presentation.Trending;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;
import vo.UserVO;

/**
 * Created by Administrator on 2016/5/3.
 */
public class TrendingController implements MyController{

    @FXML
    private ComboBox RepoTrendCombo;

    @FXML
    private ComboBox UserTrendCombo;

    @FXML
    private ComboBox LangCombo;

    @FXML
    private FlowPane RepoPane;

    @FXML
    private FlowPane UserPane;

    /**
     * 项目翻页部件
     */
    @FXML
    private Button rpgUp;
    @FXML
    private Button rpgDn;
    @FXML
    private Button rfpg;
    @FXML
    private Button rlpg;
    @FXML
    private TextField rpgNum;
    @FXML
    private Label rmaxPg;

    /**
     * 用户翻页部件
     */
    @FXML
    private Button UserpgUp;
    @FXML
    private Button UserpgDn;
    @FXML
    private Button Userfpg;
    @FXML
    private Button Userlpg;
    @FXML
    private TextField UserpgNum;
    @FXML
    private Label UsermaxPg;

    private FXUITest fxuiTest;

    public void initialize() {
        RepoTrendCombo.getItems().addAll("today","this week");
        UserTrendCombo.getItems().addAll("today","this week");
        LangCombo.getItems().addAll("Java","Ruby","Python","CSS");
    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {

    }

    /**
     * 获取项目的子面板
     * @param vo
     * @return
     */
    private AnchorPane getRepoSub(RepositoryVO vo){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepoTrend.fxml"));
        AnchorPane anchorPane = new AnchorPane();
        SubRepoTrendController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();

        return anchorPane;
    }

    /**
     * 获取用户的子面板
     * @param vo
     * @return
     */
    private AnchorPane getUserSub(UserVO vo){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserTrend.fxml"));
        AnchorPane anchorPane = new AnchorPane();
        SubUserTrendController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();

        return anchorPane;
    }
}
