package presentation.searchui;

import Util.Repository_Sort;
import businesslogic.RepositoryBL.RepositoryController;
import businesslogicService.RepositoryBLService;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.RepositoryVO;
import vo.ScreenVO;

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
    private ArrayList<ToggleButton> category = new ArrayList<>();
    private ArrayList<ToggleButton> time = new ArrayList<>();
    private ArrayList<ToggleButton> language = new ArrayList<>();
    @FXML
    private FlowPane categoryPane;
    @FXML
    private FlowPane timePane;
    @FXML
    private FlowPane languagePane;

    private ToggleGroup langGroup = new ToggleGroup();
    private ToggleGroup timeGroup = new ToggleGroup();
    private ToggleGroup categoryGroup = new ToggleGroup();
    /**
     * 排序部件
     */
    private enum buttonState{UNCLICK,UP,DOWN}
    private ArrayList<Button> bs=new ArrayList<>();
    @FXML
    private Button star;
    @FXML
    private Button fork;
    @FXML
    private Button general;
    @FXML
    private Button contributor;
    @FXML
    private AnchorPane buttons_p;
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
        initFilters();
        langGroup.getToggles().addAll(language);
        timeGroup.getToggles().addAll(time);
        categoryGroup.getToggles().addAll(category);
        pgNum.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.ENTER){
                    handlePgNum();
                }
            }
        });
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
        updateMaxPages(vos.size());
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

        /**
         * 淡入淡出列表特效
         */
//        FadeTransition ft=new FadeTransition(javafx.util.Duration.millis(1500),flowPane);
//        ft.setFromValue(0.05);
//        ft.setToValue(1.0);
//        ft.setCycleCount(0);
//        ft.setAutoReverse(true);
//        ft.play();
        playList();
    }

    private void playList(){
        for (int i=0;i<flowPane.getChildren().size();i++){
            Node n=flowPane.getChildren().get(i);
            FadeTransition ft=new FadeTransition(javafx.util.Duration.millis(1000+i*200),n);
            ft.setFromValue(0.05);
            ft.setToValue(1.0);
            ft.setCycleCount(0);
            ft.setAutoReverse(true);
            ft.play();
        }
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

    /**
     * 初始化筛选组件
     */
    private void initFilters() {
        for (Node n : languagePane.getChildren()) {
            final ToggleButton t = (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        handleScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            language.add(t);
        }

        for (Node n : timePane.getChildren()) {
            final ToggleButton t = (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        handleScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            time.add(t);
        }
        for (Node n : categoryPane.getChildren()) {
            final ToggleButton t = (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        handleScreen();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            category.add(t);
        }
    }

    /**
     * 筛选语言处理
     */
//    private void handleLanguage(String lang) throws IOException {
//        vos.clear();
//        Iterator<RepositoryVO> itr = bl.screen();
//        while (itr.hasNext()) {
//            vos.add(itr.next());
//        }
//
//        page_max = (int) (vos.size() / 6);//计算最大页数
//        maxPg.setText(String.valueOf(page_max));
//        updatePage();
//    }

    /**
     * 获取现在各筛选条件情况
     *
     * @return 一个反映现在筛选情况的ScreenVO
     */
    private ScreenVO getPresentFilter() {
        String langtxt = "";
        String timetxt = "";
        String categorytxt = "";
        if (langGroup.getSelectedToggle() != null) {
            ToggleButton langB = (ToggleButton) langGroup.getSelectedToggle().selectedProperty().getBean();
            langtxt = langB.getText();
        }
        if (timeGroup.getSelectedToggle() != null) {
            ToggleButton timeB = (ToggleButton) timeGroup.getSelectedToggle().selectedProperty().getBean();
            timetxt = timeB.getText();
        }

        if (categoryGroup.getSelectedToggle() != null) {
            ToggleButton categoryB = (ToggleButton) categoryGroup.getSelectedToggle().selectedProperty().getBean();
            categorytxt = categoryB.getText();
        }
        return new ScreenVO(timetxt, langtxt, categorytxt);
    }

    private void handleScreen() throws IOException {
        vos.clear();


        Iterator<RepositoryVO> itr = bl.screen(getPresentFilter());
        while (itr.hasNext()) {
            vos.add(itr.next());
        }

        updateMaxPages(vos.size());
        updatePage();
    }


    public void setKey(String key) {
        this.key = key;
    }

    @FXML
    private void handleStar() {
        vos.clear();
        try {
            Iterator<RepositoryVO> itr = bl.sort(Repository_Sort.star);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateMaxPages(vos.size());
        updatePage();
    }

    @FXML
    private void handleFork() {
        vos.clear();
        try {
            Iterator<RepositoryVO> itr = bl.sort(Repository_Sort.fork);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateMaxPages(vos.size());
        updatePage();
    }

    @FXML
    private void handleGeneral() {
        repaint();
    }

    @FXML
    private void handleContributor() {
        vos.clear();
        try {
            Iterator<RepositoryVO> itr = bl.sort(Repository_Sort.contributor);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateMaxPages(vos.size());

        updatePage();

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
            if(Integer.parseInt(pgNum.getText())>page_max||Integer.parseInt(pgNum.getText())<=0)
                throw new NumberFormatException();
            page = Integer.parseInt(pgNum.getText());
            updatePage();
        } catch (NumberFormatException e) {
            System.out.println("页数格式错误");
            e.printStackTrace();
        }
    }

    private void updateMaxPages(int i) {
        if (i == 0) {
            page_max = 0;
        } else {
            page_max = (int) (i / 6);//计算最大页数
            if (page_max == 0) {
                page_max = 1;
            }
        }
        maxPg.setText(String.valueOf(page_max));

    }
}
