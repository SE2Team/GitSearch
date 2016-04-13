package presentation;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import com.aquafx_project.AquaFx;
import com.aquafx_project.controls.skin.AquaButtonSkin;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.homeui.HomeController;
import presentation.repoCheckui.CheckRepoController;
import presentation.searchui.RepSearchController;
import presentation.searchui.UserSearchController;
import presentation.statistics.RepoStatisticsController;
import presentation.statistics.UserStatisticsController;
import presentation.userCheckui.UserCheckController;
import vo.RepositoryVO;
import vo.UserVO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class FXUITest extends Application {
    private Stage primaryStage;
    private BorderPane homeLayout;
    private AnchorPane searchRepoPane;
    private AnchorPane searchUserPane;
    private RepSearchController repSearchController;
    private UserSearchController userSearchController;
    private static int WIDTH=1280;
    private static int HEIGHT=720;
    /**
     * 实现前进和后退的两个栈
     */
    private Stack<Node> bpanes=new Stack<Node>();
    private Stack<Node> apanes=new Stack<Node>();


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("GitSearch");

        primaryStage.setResizable(false);
        initHome();
        searchRepo("");
//        searchUser("");
//        checkRepo();
//        checkUser();
    }

    private void initHome() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("./homeui/Home.fxml"));

        try {
            homeLayout = (BorderPane) loader.load();
            HomeController controller = loader.getController();
            controller.setFxui(this);
            controller.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(homeLayout);
        homeLayout.setCenter(null);
        primaryStage.setScene(scene);

        primaryStage.show();
//        AquaFx.style();
    }


    public static void main(String[] args) {
        launch();
    }

    public RepositoryVO test_getrepo() throws IOException {
        RepositoryBLService bl = new RepositoryController();
        return bl.checkRepository("mojombo", "grit");
//        return bl.checkRepository("technoweenie","restful-authentication");
    }

    public UserVO test_getuser() throws IOException {
        UserBLService bl = new UserController();
        return bl.CheckUser("technoweenie");
    }

    public void checkRepo(RepositoryVO vo) {
        this.push();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("repoCheckui/CheckRepo.fxml"));

        AnchorPane anchorPane;
        try {
            anchorPane = (AnchorPane) loader.load();
            CheckRepoController controller = loader.getController();
            controller.setFxui(this);
            controller.setVo(vo);
            homeLayout.setCenter(anchorPane);
            controller.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkRepo() {
        try {
            checkRepo(test_getrepo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkUser(UserVO vo) {
        this.push();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("userCheckui/UserCheck.fxml"));

        AnchorPane anchorPane;
        try {
            anchorPane = (AnchorPane) loader.load();
            UserCheckController controller = loader.getController();
            controller.setFxui(this);
            controller.setVo(vo);
            controller.repaint();
            homeLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkUser() {
        try {
            checkUser(test_getuser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * call by HomeController pass a key
     * @param key
     */
    public void searchRepo(String key) {
        this.push();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("searchui/RepSearch.fxml"));

        try {
            searchRepoPane = (AnchorPane) loader.load();
            repSearchController = loader.getController();
            repSearchController.setFxui(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        repSearchController.setKey(key);
        repSearchController.repaint();
        homeLayout.setCenter(searchRepoPane);
    }

    public void searchUser(String key) {
        this.push();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("searchui/UserSearch.fxml"));

        try {
            searchUserPane = (AnchorPane) loader.load();
            userSearchController = loader.getController();
            userSearchController.setFxui(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        userSearchController.setKey(key);
        userSearchController.repaint();
        homeLayout.setCenter(searchUserPane);
    }

    public void repoStatistics() {
        this.push();
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(this.getClass().getResource("statistics/RepoStatisticsAnc.fxml"));

        try {
            AnchorPane repoStatisticsPane=(AnchorPane) loader.load();
            RepoStatisticsController controller=loader.getController();
            controller.setFxui(this);
            controller.repaint();
            homeLayout.setCenter(repoStatisticsPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void userStatistics() {
        this.push();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("statistics/UserStatistics.fxml"));
        try {
            AnchorPane userStatisticPane=(AnchorPane)loader.load();
            UserStatisticsController controller=loader.getController();
            controller.setFxui(this);
            controller.repaint();
            homeLayout.setCenter(userStatisticPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BorderPane getHomeLayout() {
        return homeLayout;
    }

    /**
     * 后退栈压栈，然后清空前进栈
     */
    public void push(){
        if(this.homeLayout.getCenter()==null)
            return;
        bpanes.push((Parent) this.homeLayout.getCenter());
        apanes.removeAllElements();
//        System.out.println("压后退栈");
    }


    /**
     * 后退栈出栈并压到前进栈
     */
    public void pop(){
//        System.out.println("出后退栈");
        if (bpanes.size()<=0){
            return;
        }
        Node p=bpanes.pop();
        apanes.push(homeLayout.getCenter());
        homeLayout.setCenter(p);
    }

    /**
     * 前进栈出栈，压进后退栈
     */
    public void repush(){
        if (apanes.size()<=0){
            return;
        }
        Node p=apanes.pop();
        bpanes.push(homeLayout.getCenter());
//        System.out.println("前进栈出栈");

        homeLayout.setCenter(p);
    }
}
