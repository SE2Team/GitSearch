package presentation.homeui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class HomeController implements MyController{

    @FXML
    private Button back;
    @FXML
    private Button advance;
    @FXML
    private Button home;
    @FXML
    private Button search_pane;
    @FXML
    private Button search_button;//开始搜索的按钮
    @FXML
    private Button ustatistics;
    @FXML
    private Button rstatistics;
    @FXML
    private TextField searchText;
    @FXML
    private ComboBox comboBox;

    private RepositoryBLService rbl=new RepositoryController();
    private UserBLService ubl=new UserController();

    private FXUITest fxui;

    public void initialize() {
        comboBox.getItems().addAll("用户");
    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {

    }
    @FXML
    private void handleBack(){

    }

    @FXML
    private void handleAdvance(){

    }

    @FXML
    private void handleHome(){

    }

    @FXML
    private void handleSearch_b(){
        if(comboBox.getValue()=="项目"){

        }else if(comboBox.getValue()=="用户"){

        }
    }

    @FXML
    private void handleUStatistics(){

    }

    @FXML
    private void handleRStatistics(){

    }


}
