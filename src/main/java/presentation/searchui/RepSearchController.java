package presentation.searchui;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class RepSearchController implements MyController {

    /**
     * 筛选部件
     */
    @FXML
    private ArrayList<Button> category;
    @FXML
    private ArrayList<Button> language;
    @FXML
    private ArrayList<Button> time;
    /**
     * 排序部件
     */
    @FXML
    private Button star;
    @FXML
    private Button fork;
    @FXML
    private Button general;
    @FXML
    private Button contributor;
    /**
     * 翻页部件
     */
    @FXML
    private Button pgUp;
    @FXML
    private Button pgDn;
    @FXML
    private Button fpg;
    @FXML
    private Button lpg;
    @FXML
    private TextField pgNum;
    @FXML
    private FlowPane flowPane;
    @FXML
    private Label maxPg;
    /**
     * 界面无关变量
     */
    private int page = 1;
    private RepositoryBLService bl = new RepositoryController();
    private ArrayList<RepositoryVO> vos = new ArrayList<RepositoryVO>();
    private FXUITest fxuiTest;
    private String key = "";//搜索关键字
    private int page_max = 0;

    public void initialize() {

    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    /**
     * 将结果读进数组来
     */
    public void repaint() {
        vos.clear();
        try {
            Iterator<RepositoryVO> itr = bl.Search(key);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        page_max = (int) (vos.size() / 6);//计算最大页数
        maxPg.setText(String.valueOf(page_max));
        updatePage();
    }

    /**
     * 用于本地更新页面（翻页）的方法
     */
    private void updatePage() {
        /**
         * remove it's small pane
         */
        if (flowPane.getChildren().size() != 0)
            flowPane.getChildren().remove(0, flowPane.getChildren().size());


        for (int i = 0; i < 6; i++) {
            if (((page - 1) * 6 + i) >= vos.size()) {
                break;
            }
            try {
                flowPane.getChildren().add(getSub(vos.get((page - 1) * 6 + i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        pgNum.setText(String.valueOf(page));
    }

    /**
     * construct small pane
     *
     * @param vo
     * @return
     * @throws IOException
     */
    private AnchorPane getSub(RepositoryVO vo) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepInfo.fxml"));
        AnchorPane anchorPane = loader.load();
        SubRepInfoController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();
        return anchorPane;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @FXML
    private void handleStar() {

    }

    @FXML
    private void handleFork() {
    }

    @FXML
    private void handleGeneral() {
        repaint();
    }

    @FXML
    private void handleContributor() {

    }

    @FXML
    private void handlePgUp() {
        if (page <= 1) {
            return;
        } else {
            page--;
            updatePage();
        }
    }

    @FXML
    private void handlePgDn() {
        if (page + 1 > page_max) {
            return;
        } else {
            page++;
            updatePage();
        }
    }

    @FXML
    private void handleFpg() {
        page = 1;
        updatePage();
    }

    @FXML
    private void handleLpg() {
        page = page_max;
        updatePage();
    }

    @FXML
    private void handlePgNum() {
        try {
            page = Integer.parseInt(pgNum.getText());
        } catch (NumberFormatException e) {
            System.out.println("页数格式错误");
            e.printStackTrace();
        }
    }
}
