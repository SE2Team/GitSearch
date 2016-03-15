package presentation.repoCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.FXUITest;
import vo.RepositoryVO;

import java.io.IOException;

/**
 * Created by moeyui on 2016/3/14 0014.
 */
public class CheckRepoController {
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

    private RepositoryVO vo;



    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
        try {
            this.vo=fxui.test_getrepo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (vo==null){
            return;
        }
        reponame.setText(vo.getName());
        description.setText(vo.getDescription());
//        System.out.println(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers_count()));
        forks.setText(String.valueOf(vo.getForks()));
        subscribers.setText(String.valueOf(vo.getSubscribers_count()));
//        collaborator.setText(vo.getC);
        contributors.setText(String.valueOf(vo.getContributor()));
    }
    @FXML
    private void initialize(){

    }

    public void setVo(RepositoryVO vo) {
        this.vo = vo;
    }
}
