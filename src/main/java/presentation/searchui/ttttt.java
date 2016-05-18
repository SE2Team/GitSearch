package presentation.searchui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by moeyui on 2016/3/27 0027.
 */
public class ttttt extends Application{

    private Stage stage=new Stage();
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("./test2.fxml"));
        AnchorPane anchorPane=(AnchorPane) loader.load();
        testController controller=loader.getController();
        Scene scene=new Scene(anchorPane);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
