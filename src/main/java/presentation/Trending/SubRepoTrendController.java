package presentation.Trending;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    private ImageView change_img;

    private FXUITest fxui;

    private RepositoryVO vo;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    public void repaint() {
        name.setText(vo.getName());
        language.setText(vo.getLanguage());
        description.setText(vo.getDescription());
        stars.setText(String.valueOf(vo.getStargazers_count()));
        forks.setText(String.valueOf(vo.getForks()));
        handleImg();
        changes.setText(String.valueOf(vo.getStarDevation()));
//        contributors.set(String.valueOf(vo.getContributor()));
    }

    public void setVo(RepositoryVO vo) {
        this.vo = vo;
    }

    @FXML
    private void handleCheck(){
        fxui.checkRepo(vo);
    }

    private void handleImg(){
        if(vo.getStarDevation()>0){
            change_img.setStyle("-fx-image: url(\"Images/up.png\");");
        }else if(vo.getStarDevation()==0){
            change_img.setStyle("-fx-image: url(\"Images/noChange.png\");");
        }else if(vo.getStarDevation()<0){
            change_img.setStyle("-fx-image: url(\"Images/down.png\");");

        }
    }
}
