package presentation.userCheckui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/25 0025.
 */
public class SubRepoController implements MyController {

    @FXML
    private Label label;
    @FXML
    private ImageView imageView;
    @FXML
    private Tooltip fullName;

    private String name;
    private RepositoryBLService bl=new RepositoryController();

    public FXUITest fxuiTest;

    public void initialize() {
    }

    public void setFxui(FXUITest fxui) {
        fxuiTest=fxui;
    }

    public void repaint() {

    }
    public void setText(String str){
        name=str;
        if(str=="@more"){
            setMore();
            return;
        }
        this.label.setText(str);
        this.fullName.setText(str);
    }

    public void setMore(){
        this.label.setText("More...");
        imageView.setVisible(false);
    }
    @FXML
    private void checkRepo(){
        String str1,str2;
        String str[]=name.split("/");
        try {
            fxuiTest.checkRepo(bl.checkRepository(str[0],str[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
