package presentation.userCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.kohsuke.github.GHRepository;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;
import java.util.Iterator;

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
    private Tooltip fullUserName;
    @FXML
    private Tooltip fullLogin;
    @FXML
    private LineChart contriChart;
    @FXML
    private ImageView imageView;

    private FXUITest fxui;

    @FXML
    public void initialize(){

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        regTime.setText(vo.getCreated_at());
//        String comp=vo.getCompany().replaceAll(" ","")==""?"Unknown":vo.getCompany();
        company.setText(vo.getCompany());
        followers.setText(String.valueOf(vo.getFollowers()));
//        String emailText=vo.getEmail()==""?"Unknown":vo.getEmail();
        email.setText(vo.getEmail());
        following.setText(String.valueOf(vo.getFollowing()));
        login.setText(vo.getLogin());
        try {
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fullUserName.setText(vo.getName());
        fullLogin.setText(vo.getLogin());
        name.requestFocus();//把焦点拿走
//        imageView.setImage(new Image(vo.getAvatar()));
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
        Iterator<GHRepository> itrhas=vo.getHas();
        if (itrhas!=null) {
            while (itrhas.hasNext()) {
                poprepo.getChildren().addAll(getSub(itrhas.next()));

            }
        }

    }

    public Parent getSub(GHRepository vo) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserCheckRep.fxml"));
        AnchorPane anchorPane=loader.load();
        SubRepoController controller=loader.getController();

        controller.setFxui(fxui);
        controller.set(this.vo.getLogin(),vo.getName());
        controller.repaint();
        return anchorPane;
    }

}
