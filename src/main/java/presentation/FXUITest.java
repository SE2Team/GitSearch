package presentation;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.homeui.HomeController;
import presentation.repoCheckui.CheckRepoController;
import presentation.searchui.RepSearchController;
import presentation.searchui.UserSearchController;
import presentation.userCheckui.CheckUserController;
import vo.RepositoryVO;
import vo.UserVO;

import java.io.IOException;

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


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
        primaryStage.setTitle("GitSearch");
        initHome();
//        checkRepo();
        checkUser();
    }

    private void initHome(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homeui/Home.fxml"));
        try {
            homeLayout=(BorderPane) loader.load();
            HomeController controller=loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(homeLayout);
        primaryStage.setScene(scene);

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch();
    }

    public RepositoryVO test_getrepo() throws IOException {
        RepositoryBLService bl=new RepositoryController();
        return bl.checkRepository("mojombo","grit");
//        return bl.checkRepository("technoweenie","restful-authentication");
    }

    public UserVO test_getuser() throws IOException {
        UserBLService bl=new UserController();
        return bl.CheckUser("technoweenie");
    }

    public void checkRepo(RepositoryVO vo){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("repoCheckui/CheckRepo.fxml"));

        AnchorPane anchorPane;
        try {
            anchorPane = (AnchorPane)loader.load();
            CheckRepoController controller=loader.getController();
            controller.setFxui(this);
            controller.setVo(vo);
            homeLayout.setCenter(anchorPane);
            controller.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void checkRepo(){
        try {
            checkRepo(test_getrepo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkUser(UserVO vo){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("userCheckui/CheckUser.fxml"));

        AnchorPane anchorPane;
        try {
            anchorPane=(AnchorPane) loader.load();
            CheckUserController controller=loader.getController();
            controller.setFxui(this);
            controller.setVo(vo);
            controller.repaint();
            homeLayout.setCenter(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void checkUser(){
        try {
            checkUser(test_getuser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchRepo(){
        if (searchRepoPane==null){
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(this.getClass().getResource("searchui/RepSearch.fxml"));
            repSearchController=loader.getController();
            repSearchController.setFxui(this);
            try {
                searchRepoPane=(AnchorPane) loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(searchRepoPane!=null) {
        }
        homeLayout.setCenter(searchRepoPane);


    }

    public void searchUser(){
        if (searchUserPane==null){
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(this.getClass().getResource("searchui/UserSearch.fxml"));
            userSearchController=loader.getController();
            userSearchController.setFxui(this);
            try {
                searchUserPane=(AnchorPane)loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            homeLayout.setCenter(searchUserPane);
        }
    }
    public void repoStatistics(){

    }

    public void userStatistics(){

    }

    public BorderPane getHomeLayout() {
        return homeLayout;
    }
}
