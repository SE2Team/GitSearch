package presentation.repoCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

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
//        System.out.println(vo.getDescription());
//        stars.setText(String.valueOf(vo.getStargazers_count()));
//        forks.setText(String.valueOf(vo.getForks()));
//        subscribers.setText(String.valueOf(vo.getSubscribers_count()));
//        collaborator.setText(String.valueOf(vo.getContributor()));
//        contributors.setText(String.valueOf(vo.getContributor()));
//        language.setText(vo.getLanguage());
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
}
