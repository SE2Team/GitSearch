package presentation.userCheckui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.kohsuke.github.GHEventInfo;
import org.kohsuke.github.GHRepository;
import presentation.FXUITest;
import presentation.common.MyController;

import java.io.IOException;

/**
 * Created by moeyui on 2016/5/21 0021.
 */
public class SubUserEvent implements MyController {
    private FXUITest fxui;
    @FXML
    private Label type;
    @FXML
    private Label repo;
    @FXML
    private ImageView eventImg;
    private RepositoryBLService bl=new RepositoryController();
    private GHRepository repository;


    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxui = fxui;
    }

    @Override
    public void repaint() {

    }

    public void set(GHEventInfo event) throws IOException {
        type.setText(event.getType().name());
        repository=event.getRepository();
        repo.setText(repository.getFullName());
    }
    @FXML
    private void check(){
        try {
            fxui.checkRepo(bl.checkRepository(repository.getOwner().getLogin(),repository.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
