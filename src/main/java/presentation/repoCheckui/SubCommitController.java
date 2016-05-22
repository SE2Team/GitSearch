package presentation.repoCheckui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import org.kohsuke.github.GHCommit;
import presentation.FXUITest;
import presentation.common.MyController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/20.
 */
public class SubCommitController implements MyController{
    FXUITest fxuiTest;

//    private RepositoryVO vo;
    private GHCommit commit;

    Date date;
    String logIn;
    String time;

    @FXML
    private Tooltip fullCommitInfo;
    @FXML
    private Label commitDesc;

    @FXML
    private Label commitInfo;

    @Override
    public void initialize() {

    }

    @Override
    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    @Override
    public void repaint() {

        try {
            logIn = commit.getCommitter().getLogin();
            if(commit.getLastStatus()==null){
                commitInfo.setText(logIn+" committed");
                commitDesc.setText(commit.getCommitShortInfo().getMessage());
            }else{
                date =commit.getLastStatus().getUpdatedAt();
                time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
                commitInfo.setText(logIn+" committed at "+time);
                commitDesc.setText(commit.getCommitShortInfo().getMessage());
                fullCommitInfo.setText(commit.getCommitShortInfo().getMessage());
//                System.out.println(commit.getCommitShortInfo().getMessage());
//                System.out.println(logIn+" committed at "+time);
//                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCommit(GHCommit commit){
        this.commit = commit;
    }
}
