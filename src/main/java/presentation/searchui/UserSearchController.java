package presentation.searchui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class UserSearchController implements MyController {
    /**
     * 筛选部件
     */
    private ArrayList<Button> time;
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

    /**
     * 排序部件
     */
    @FXML
    private Button general;
    @FXML
    private Button followers;
    @FXML
    private Button repo;

    @FXML
    private FlowPane flowPane;

    /**
     * 界面无关变量
     */
    private FXUITest fxuiTest;
    private int page = 1;
    private ArrayList<UserVO> vos;
    private UserBLService bl = new UserController();
    private String key="";//搜索关键字

    public void initialize() {
    }

    public void setFxui(FXUITest fxui) {
        fxuiTest = fxui;
    }

    public void repaint() {
        int cout=0;
        flowPane=new FlowPane();//指定一个新的pane
        pgNum.setText(String.valueOf(page));
        try {
            Iterator<UserVO> itr=bl.search(key);

            while (itr.hasNext()){
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(UserVO temp:vos){
            try {
                flowPane.getChildren().add(getSub(temp));
                cout++;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cout>=8){
                break;
            }
        }


    }

    private AnchorPane getSub(UserVO vo) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepinfo.fxml"));
        SubUserInfoController controller=loader.getController();
        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();
        return loader.load();
    }
    @FXML
    private void handlePgUp() {

    }

    @FXML
    private void handlePgDn() {

    }

    @FXML
    private void handleFpg() {

    }

    @FXML
    private void handleLpg() {

    }

    @FXML
    private void handlePgNum() {

    }

    @FXML
    private void handleGeneral() {

    }

    @FXML
    private void handleFollowers() {


    }

    @FXML
    private void handleRepo(){

    }

}
