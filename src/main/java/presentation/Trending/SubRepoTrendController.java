package presentation.Trending;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.hamcrest.Factory;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

/**
 * Created by Administrator on 2016/5/4.
 */
public class SubRepoTrendController implements MyController{

    @FXML
    private Label name;
    @FXML
    private Label language;
//    @FXML
//    private Label time;
    @FXML
    private Label description;
    @FXML
    private Label forks;
    @FXML
    private Label stars;
    @FXML
    private Label changes;

    private FXUITest fxui;

    private RepositoryVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        description.setText(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers()));
        forks.setText(String.valueOf(vo.getForks()));
//        contributors.setText(String.valueOf(vo.getContributor()));
    }

    public void setVo(RepositoryVO vo) {
        this.vo = vo;
    }

    @FXML
    private void handleCheck(){
        fxui.checkRepo(vo);
    }

}
