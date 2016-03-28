package presentation.homeui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import presentation.FXUITest;
import presentation.common.MyController;

/**
 * Created by myk on 16-3-26.
 */
public class GitHomeController implements MyController {
    private FXUITest fxui;

    @FXML
    private Button search;
    @FXML
    private TextField searchText;
    @FXML
    private ComboBox comboBox;

    public void initialize() {
        comboBox.getItems().addAll("项目","用户");
        comboBox.getSelectionModel().selectFirst();
    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {

    }

    @FXML
    private void handleSearch(){
        if(comboBox.getValue()=="项目"){
            fxui.searchRepo(searchText.getText().trim());
        }else if(comboBox.getValue()=="用户"){
            System.out.println(searchText.getText());
            fxui.searchUser(searchText.getText().trim());
        }
    }
}
