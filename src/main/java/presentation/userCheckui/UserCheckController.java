package presentation.userCheckui;

import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/15 0015.
 */
public class UserCheckController implements MyController {
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
    private FlowPane showList;

    @FXML
    private Tooltip fullUserName;
    @FXML
    private Tooltip fullLogin;
    @FXML
    private LineChart contriChart;
    @FXML
    private ImageView imageView;
    @FXML
    private ComboBox combobox;

    /**
     * showList默认项目数量
     */
    private static int SHOWLISTSIZE;

    private FXUITest fxui;

    /**
     * 缓存列表以加快速度
     */
    private ArrayList<Parent> followingList = new ArrayList<>();
    private ArrayList<Parent> owningList = new ArrayList<>();
    private ArrayList<Parent> eventList=new ArrayList<>();

    @FXML
    public void initialize() {
        SHOWLISTSIZE = 10;
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
        email.setText(vo.getEmail() == null ? "Unknown" : vo.getEmail());
        following.setText(String.valueOf(vo.getFollowing()));
        login.setText(vo.getLogin());
//        try {
//            handleCheckRepo();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        fullUserName.setText(vo.getName());
        fullLogin.setText(vo.getLogin());
        name.requestFocus();//把焦点拿走
//        imageView.setImage(new Image(vo.getAvatar()));
        combobox.getItems().addAll("Repositories", "Following","Event");
        combobox.getSelectionModel().selectFirst();

    }

    /**
     * get vo with arrays
     *
     * @param vo
     */
    public void setVo(UserVO vo) {
        UserBLService bl = new UserController();
        try {
            this.vo = bl.CheckUser(vo.getLogin());
        } catch (IOException e) {
            System.out.println("获取详细用户信息失败");
        }
    }


    private Parent getSub(GHRepository vo) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserCheckRep.fxml"));
        AnchorPane anchorPane = loader.load();
        SubRepoController controller = loader.getController();

        controller.setFxui(fxui);
        controller.set(this.vo.getLogin(), vo.getName());
        controller.repaint();
        return anchorPane;
    }

    private Parent getSub(GHUser user) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserCheckUser.fxml"));
        AnchorPane anchorPane = loader.load();
        SubUserController controller = loader.getController();

        controller.setFxui(fxui);
        controller.set(user);
        controller.repaint();
        return anchorPane;
    }

    private Parent getSub(GHEventInfo event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserCheckEvent.fxml"));
        AnchorPane anchorPane = loader.load();
        SubUserEvent controller = loader.getController();

        controller.setFxui(fxui);
        controller.set(event);
        controller.repaint();
        return anchorPane;
    }

    @FXML
    private void handleCheckFollowing() throws IOException {
        showList.getChildren().clear();
        if (followingList.size() == 0) {
            Iterator<GHUser> itr = vo.getDpo().listFollows()._iterator(SHOWLISTSIZE);
            int i = 0;
            if (itr != null) {
                while (itr.hasNext() && i++ < SHOWLISTSIZE) {
                    followingList.add(getSub(itr.next()));
                }
            }
        }
        showList.getChildren().addAll(followingList);

    }

    @FXML
    private void handleCheckRepo() throws IOException {
        showList.getChildren().clear();

        if (owningList.size() == 0) {
            Iterator<GHRepository> itrhas = vo.getHas();
            int i = 0;
            if (itrhas != null) {
                while (itrhas.hasNext() && i++ < SHOWLISTSIZE) {
                    owningList.add(getSub(itrhas.next()));
                }
            }
        }
        showList.getChildren().addAll(owningList);

    }

    @FXML
    private void handleComboBox() throws IOException {
        if (combobox.getValue() == "Repositories") {
            handleCheckRepo();
        } else if (combobox.getValue() == "Following") {
            handleCheckFollowing();
        } else if(combobox.getValue() == "Event"){
            handleUEvent();
        }
    }
    @FXML
    private void handleUEvent() throws IOException {
        showList.getChildren().clear();
        if(eventList.size()==0){
            Iterator<GHEventInfo> itr=vo.getDpo().listEvents().iterator();
            int i= 0;
            if(itr!=null){
                while (itr.hasNext()&&i++<SHOWLISTSIZE){
                    eventList.add(getSub(itr.next()));
                }
            }
        }
        showList.getChildren().addAll(eventList);
    }

}
