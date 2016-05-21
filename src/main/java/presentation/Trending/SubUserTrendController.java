package presentation.Trending;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

/**
 * Created by Administrator on 2016/5/4.
 */
public class SubUserTrendController implements MyController{
    @FXML
    private ImageView portrait;
    @FXML
    private Label name;
    @FXML
    private Label LogIn;
    @FXML
    private Label followers;
    @FXML
    private Label repos;
    @FXML
    private Label changes;
    @FXML
    private ImageView change_img;

    private FXUITest fxuiTest;

    private UserVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {
        String nameText = vo.getName() != "" ? vo.getName() : "Unknown";
        name.setText(nameText);
        LogIn.setText(vo.getLogin());
        followers.setText(String.valueOf(vo.getFollowers()));
        repos.setText(String.valueOf(vo.getPublic_repos()));
        portrait.setImage(vo.getUserImage());
        handleImg();
        changes.setText(String.valueOf(vo.getFollowersDeviation()));
    }

    @FXML
    private void handleCheck() {
        fxuiTest.checkUser(vo);
    }

    public void setVo(UserVO vo) {
        this.vo = vo;
    }

    private void handleImg(){
        if(vo.getFollowersDeviation()>0){
            change_img.setStyle("-fx-image: url(\"Images/up.png\");");
        }else if(vo.getFollowersDeviation()==0){
            change_img.setStyle("-fx-image: url(\"Images/no change.png\");");
        }else if(vo.getFollowersDeviation()<0){
            change_img.setStyle("-fx-image: url(\"Images/down.png\");");

        }
    }
}
