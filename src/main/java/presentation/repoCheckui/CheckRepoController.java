package presentation.repoCheckui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class CheckRepoController implements MyController{
    private FXUITest fxui;
    @FXML
    private Label stars;
    @FXML
    private Label forks;
    @FXML
    private Label contributors;
    @FXML
    private Label subscribers;
    @FXML
    private Label collaborator;
    @FXML
    private Label description;
    @FXML
    private Label reponame;

    @FXML
    private Label language;

    @FXML
    private FlowPane contributorPane;

    @FXML
    private FlowPane collaboratorPane;

//    @FXML
//    private Tab conTab;
//
//    @FXML
//    private Tab colTab;


    @FXML
    private Label owner;


    private RepositoryVO vo;



    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;

    }

    public void repaint() {
        if (vo==null){
            return;
        }
        reponame.setText(vo.getName());
        description.setText(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers()));
        forks.setText(String.valueOf(vo.getForks()));
        subscribers.setText(String.valueOf(vo.getSubscribers_count()));
        collaborator.setText(String.valueOf(vo.getContributor()));
        contributors.setText(String.valueOf(vo.getContributor()));
        language.setText(vo.getLanguage());
        try {
            setList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fxui.push();
    }

    private void setList() throws IOException {
        for(int i=0;i<vo.getContributors().size();i++){
            contributorPane.getChildren().add(getSub(vo.getContributors().get(i)));
            /**
             * 最多只能放7个+一个more
             */
            if(i>=6){
                contributorPane.getChildren().addAll(getSub("@more"));
                break;
            }
        }

        for(int i=0;i<vo.getCollaborators().size();i++){
            collaboratorPane.getChildren().add(getSub(vo.getCollaborators().get(i)));
            /**
             * 最多只能放7个+一个more
             */
            if(i>=6){
                collaboratorPane.getChildren().addAll(getSub("@more"));
                break;
            }
        }
    }
    @FXML
    public void initialize(){

    }

    /**
     * get vo with arrays
     * @param vo
     */
    public void setVo(RepositoryVO vo) {
        this.vo = vo;
    }

    public Parent getSub(String str) throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepCheckContri.fxml"));
        AnchorPane anchorPane=loader.load();
        SubContriController controller=loader.getController();

        controller.setFxui(fxui);
        controller.setText(str);
        controller.repaint();
        return anchorPane;
    }


}
