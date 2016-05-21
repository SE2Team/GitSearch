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
    private String userLogin;
    private RepositoryBLService bl=new RepositoryController();

    public FXUITest fxuiTest;

    public void initialize() {
    }

    public void setFxui(FXUITest fxui) {
        fxuiTest=fxui;
    }

    public void repaint() {

    }

    /**
     * 设置小面板的各属性
     * @param userLogin
     * @param repo
     */
    public void set(String userLogin, String repo){
        name= repo;
        if(repo =="@more"){
            setMore();
            return;
        }
        this.label.setText(repo);
        this.fullName.setText(repo);
    }

    public void setMore(){
        this.label.setText("More...");
        imageView.setVisible(false);
    }
    @FXML
    private void check(){
        try {
            fxuiTest.checkRepo(bl.checkRepository(userLogin,name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
