package presentation.searchui;

import Util.User_Sort;
import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
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
import javafx.scene.paint.Color;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class UserSearchController implements MyController {
    /**
     * 筛选部件
     */
    private ArrayList<ToggleButton> time = new ArrayList<>();
    private ToggleGroup timeGroup = new ToggleGroup();

    @FXML
    private FlowPane flowPane2;
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
    private Label maxPg;

    /**
     * 排序部件
     */
    @FXML
    private Button general;
    @FXML
    private Button followers;
    @FXML
    private Button repo;
    @FXML
    private ToggleButton upOrDown;

    @FXML
    private FlowPane flowPane;
    @FXML
    private AnchorPane buttons_p;


    /**
     * 界面无关变量
     */
    private FXUITest fxuiTest;
    private int page = 1;
    private ArrayList<UserVO> vos = new ArrayList<UserVO>();
    private UserBLService bl = new UserController();
    private String key = "";//搜索关键字
    private int page_max = 0;
    private Button[] buttons;

    public void initialize() {
        buttons = new Button[]{followers,repo};
        for (Node n : flowPane2.getChildren()) {
            final ToggleButton t = (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (t.isSelected() == false)
                        handleScreen("");
                    else
                        handleScreen(t.getText());
                }
            });
            time.add((ToggleButton) n);
        }
        timeGroup.getToggles().addAll(time);

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
        fxuiTest = fxui;
    }

    /**
     * 将结果读进数组来
     */
    public void repaint() {
        vos.clear();//清空数组
        try {
            Iterator<UserVO> itr = bl.search(key);
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
     * 列表变换动画特效
     */
    private void playList() {
        for (int i = 0; i < flowPane.getChildren().size(); i++) {
            Node n = flowPane.getChildren().get(i);
            FadeTransition ft = new FadeTransition(javafx.util.Duration.millis(1000 + i * 200), n);
            ft.setFromValue(0.05);
            ft.setToValue(1.0);
            ft.setCycleCount(0);
            ft.setAutoReverse(true);
            ft.play();
        }
    }

    /**
     *
     * 实现倒序排序
     * @param vos
     * @return
     */
    private ArrayList handleUpAndDown(ArrayList vos) {

        ArrayList temp = new ArrayList();

        for (int i = 0; i < vos.size(); i++) {
            temp.add(vos.get(vos.size()-i-1));
        }
        return temp;
    }

    /**
     * 处理筛选方法
     */
    private void handleScreen(String str) {
        vos.clear();//清空数组
        Iterator<UserVO> itr = null;
        try {
            itr = bl.screenTime(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (itr.hasNext()) {
            vos.add(itr.next());
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

        for (int i = 0; i < 8; i++) {
            try {
                if (((page - 1) * 8 + i) >= vos.size()) {
                    break;
                }
                flowPane.getChildren().add(getSub(vos.get((page - 1) * 8 + i)));//根据页数获取对应的VO
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        pgNum.setText(String.valueOf(page));
        playList();

    }

    private AnchorPane getSub(UserVO vo) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserInfo.fxml"));
        AnchorPane anchorPane = loader.load();
        SubUserInfoController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();
        return anchorPane;
    }
//    private ScreenVO getPresentFilter(){
//        String timetxt="";
//        if (timeGroup.getSelectedToggle()!=null){
//
//        }
//
//    }

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
//            e.printStackTrace();
        }
    }

    @FXML
    private void handleGeneral() {
        repaint();
    }

    @FXML
    private void handleFollowers() {
        setColor(followers.getText());
        vos.clear();//清空数组
        try {
            Iterator<UserVO> itr = bl.sortUser(User_Sort.Followers);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
            if (upOrDown.isSelected()){
                vos=handleUpAndDown(vos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        updateMaxPages(vos.size());

        page=1;
        updatePage();

    }

    @FXML
    private void handleRepo() {
        setColor(repo.getText());
        vos.clear();//清空数组
        try {
            Iterator<UserVO> itr = bl.sortUser(User_Sort.HAS);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
            if (upOrDown.isSelected()){
                vos=handleUpAndDown(vos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateMaxPages(vos.size());

        page=1;

        updatePage();

    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 更新最大页数
     * @param i
     */
    private void updateMaxPages(int i) {
        if (i == 0) {
            page_max = 0;
        } else {
            page_max = (int) (i / 8 +1);//计算最大页数
            if (page_max == 0) {
                page_max = 1;
            }
        }
        maxPg.setText(String.valueOf(page_max));

    }

    public void setColor(String text){
        for(int i=0;i<buttons.length;i++){
            if(buttons[i].getText().equals(text)){
                buttons[i].setTextFill(Color.rgb(221,118,118));
            }else{
                buttons[i].setTextFill(Color.WHITE);
            }
        }
    }
    @FXML
    private void handleUpDown(){
        ArrayList temp = new ArrayList();

        for (int i = 0; i < vos.size(); i++) {
            temp.add(vos.get(vos.size() - i - 1));
        }
        vos=temp;
        updatePage();
    }

}
