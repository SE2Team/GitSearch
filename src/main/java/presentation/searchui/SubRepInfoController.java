package presentation.searchui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class SubRepInfoController  implements MyController{
    @FXML
    private Label name;
    @FXML
    private Label description;
    @FXML
    private Label forks;
    @FXML
    private Label stars;
    @FXML
    private Label contributors;
    private RepositoryVO vo;

    private FXUITest fxui;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxui=fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        description.setText(vo.getDescription());
        forks.setText(String.valueOf(vo.getForks()));
        stars.setText(String.valueOf(vo.getStargazers_count()));
        contributors.setText(String.valueOf(vo.getContributor()));
    }

    public void setVo(RepositoryVO vo) {
        this.vo = vo;
    }

    @FXML
    private void HandleCheck(){
        fxui.checkRepo(vo);
    }
}
