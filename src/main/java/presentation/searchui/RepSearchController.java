package presentation.searchui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class RepSearchController implements MyController{

    /**
     * 筛选部件
     */
    @FXML
    private ArrayList<Button> category;
    @FXML
    private ArrayList<Button> language;
    @FXML
    private ArrayList<Button> time;
    /**
     * 排序部件
     */
    @FXML
    private Button star;
    @FXML
    private Button fork;
    @FXML
    private Button general;
    @FXML
    private Button contributor;
    /**
     * 翻页部件
     */
    @FXML
    private Button pgUp;
    @FXML
    private Button pgDn;
    @FXML
    private Button fpg;
    @FXML
    private Button lpg;
    @FXML
    private TextField pgNum;
    @FXML
    private FlowPane flowPane;
    /**
     * 界面无关变量
     */
    private int page=1;
    private RepositoryBLService bl=new RepositoryController();
    private ArrayList<RepositoryVO> vos=new ArrayList<RepositoryVO>();
    private FXUITest fxuiTest;
    private String key="";//搜索关键字

    public void initialize() {
        try {
            Iterator<RepositoryVO> itr=bl.getRepositories();
            while (itr.hasNext()){
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest=fxui;
    }

    public void repaint() {

    }

    public void repaint(ArrayList<RepositoryVO> vos){
        pgNum.setText(String.valueOf(page));
        flowPane=new FlowPane();
    }

    public void setKey(String key) {
        this.key = key;
    }

    @FXML
    private void handleStar(){

    }
    @FXML
    private void handleFork(){

    }
    @FXML
    private void handleGeneral(){

    }
    @FXML
    private void handleContributor(){

    }
    @FXML
    private void handlePgUp(){

    }
    @FXML
    private void handlePgDn(){

    }
    @FXML
    private void handleFpg(){

    }
    @FXML
    private void handleLpg(){

    }
    @FXML
    private void handlePgNum(){

    }
}
