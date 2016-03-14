package presentation;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.repoCheckui.CheckRepoController;
import vo.RepositoryVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class FXUITest extends Application {
    private Stage primaryStage;
    private BorderPane homeLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
        primaryStage.setTitle("GitSearch");
        initHome();
        initCheckRepo();
    }

    private void initHome(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("homeui/Home.fxml"));
        try {
            homeLayout=(BorderPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(homeLayout);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void initCheckRepo(){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("repoCheckui/CheckRepo.fxml"));

        AnchorPane anchorPane;
        try {
            anchorPane = (AnchorPane)loader.load();
            CheckRepoController controller=loader.getController();
            controller.setFxui(this);
//            controller.setVo(test_getrepo());
            homeLayout.setCenter(anchorPane);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }

    public RepositoryVO test_getrepo() throws IOException {
        RepositoryBLService bl=new RepositoryController();
        return bl.checkRepository("mojombo","grit");
    }
}
