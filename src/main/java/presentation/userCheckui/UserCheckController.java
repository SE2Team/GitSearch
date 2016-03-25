package presentation.userCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/15 0015.
 */
public class UserCheckController implements MyController{
    private UserVO vo;
    @FXML
    private Label name;
    @FXML
    private Label regTime;
    @FXML
    private Label company;
    @FXML
    private Label followers;
    @FXML
    private Label email;
    @FXML
    private Label following;
    @FXML
    private Label login;
    @FXML
    private FlowPane poprepo;
    @FXML
    private FlowPane relarepo;



    private FXUITest fxui;

    @FXML
    public void initialize(){

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        regTime.setText(vo.getCreated());
        String comp=vo.getCompany().replaceAll(" ","")==""?"Unknown":vo.getCompany();
        company.setText(comp);
        followers.setText(String.valueOf(vo.getFollowers()));
        email.setText(vo.getEmail());
        following.setText(String.valueOf(vo.getFollowing()));
        login.setText(vo.getLogin());
        try {
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fxui.push();
    }

    /**
     * get vo with arrays
     * @param vo
     */
    public void setVo(UserVO vo) {
        UserBLService bl=new UserController();
        try {
            this.vo = bl.CheckUser(vo.getLogin());
        } catch (IOException e) {
            System.out.println("获取详细用户信息失败");
        }
    }

    private void setList() throws IOException {
        for (int i=0;i<vo.getHas().size();i++){
            poprepo.getChildren().addAll(getSub(vo.getHas().get(i)));
            /**
             * 最多放4+1个
             */
            if (i>=3){
                poprepo.getChildren().addAll(getSub("@more"));
                break;
            }
        }


        for (int j=0;j<vo.getRelated().size();j++){
            poprepo.getChildren().addAll(getSub(vo.getHas().get(j)));
            /**
             * 最多放4+1个
             */
            if (j>=3){
                poprepo.getChildren().addAll(getSub("@more"));
                break;
            }
        }
    }

    public Parent getSub(String str) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserCheckRep.fxml"));
        AnchorPane anchorPane=loader.load();
        SubRepoController controller=loader.getController();

        controller.setFxui(fxui);
        controller.setText(str);
        controller.repaint();
        return anchorPane;
    }



}
