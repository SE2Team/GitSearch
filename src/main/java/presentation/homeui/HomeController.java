package presentation.homeui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
    private ToggleButton search_pane;
    @FXML
    private Button search_button;//开始搜索的按钮
    @FXML
    private ToggleButton ustatistics;
    @FXML
    private ToggleButton rstatistics;
    @FXML
    private TextField searchText;
    @FXML
    private ComboBox comboBox;

    private ToggleGroup top=new ToggleGroup();

    private RepositoryBLService rbl=new RepositoryController();
    private UserBLService ubl=new UserController();

    private FXUITest fxui;

    public void initialize() {
        comboBox.getItems().clear();
        comboBox.getItems().addAll("项目","用户");
        comboBox.getSelectionModel().selectFirst();
        top.getToggles().addAll(search_pane,ustatistics,rstatistics);
        search_pane.setSelected(true);
        searchText.setFocusTraversable(false);
    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {

    }
    @FXML
    private void handleBack(){
        fxui.pop();
    }

    @FXML
    private void handleAdvance(){
        fxui.repush();
    }

    @FXML
    private void handleHome(){

    }

    @FXML
    private void handleSearch_b(){
        String str="";
        if(comboBox.getValue()=="项目"){
            fxui.searchRepo(searchText.getText().trim());

            search_pane.setStyle("-fx-background-image: url(\"Images/searchRep.png\");");
        }else if(comboBox.getValue()=="用户"){
//            System.out.println(searchText.getText());
            fxui.searchUser(searchText.getText().trim());
            search_pane.setStyle("-fx-background-image: url(\"Images/searchUser.png\");");

        }
        top.getToggles().get(0).setSelected(true);
    }

    @FXML
    private void handleUStatistics(){
        ustatistics.setSelected(true);
        fxui.userStatistics();
    }

    @FXML
    private void handleRStatistics(){
        rstatistics.setSelected(true);
        fxui.repoStatistics();
    }

    @FXML
    private void handleSearch_p(){
        search_pane.setSelected(true);
        if(comboBox.getValue()=="项目"){
            fxui.searchRepo("");
        }else if(comboBox.getValue()=="用户"){
//            System.out.println(searchText.getText());
            fxui.searchUser("");
        }
    }

}
