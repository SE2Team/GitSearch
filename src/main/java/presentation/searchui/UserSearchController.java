package presentation.searchui;

import Util.User_Sort;
import businesslogic.userBL.UserController;
import businesslogicService.UserBLService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import presentation.FXUITest;
import presentation.common.MyController;
import vo.ScreenVO;
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
    private ArrayList<ToggleButton> time=new ArrayList<>();
    private ToggleGroup timeGroup =new ToggleGroup();
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button ten;
    @FXML
    private Button eleven;
    @FXML
    private Button twe;
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
    private FlowPane flowPane;



    /**
     * 界面无关变量
     */
    private FXUITest fxuiTest;
    private int page = 1;
    private ArrayList<UserVO> vos=new ArrayList<UserVO>();
    private UserBLService bl = new UserController();
    private String key = "";//搜索关键字
    private int page_max = 0;

    public void initialize() {

        for(Node n:flowPane2.getChildren()){
            final ToggleButton t= (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(t.isSelected()==false)
                        handleScreen("");
                    else
                        handleScreen(t.getText());
                }
            });
            time.add((ToggleButton) n);
        }
        timeGroup.getToggles().addAll(time);
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

        page_max = (int) (vos.size() / 8);//计算最大页数
        maxPg.setText(String.valueOf(page_max));

        updatePage();


    }

    /**
     * 处理筛选方法
     */
    private void handleScreen(String str){
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

        page_max = (int) (vos.size() / 8);//计算最大页数
        /**
         * 最少也有一页
         */
        if (page_max==0){
            page_max=1;
        }
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
        if(flowPane.getChildren().size()!=0)
            flowPane.getChildren().remove(0,flowPane.getChildren().size());

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
    }

    private AnchorPane getSub(UserVO vo) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserInfo.fxml"));
        AnchorPane anchorPane=loader.load();
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
            page = Integer.parseInt(pgNum.getText());
        } catch (NumberFormatException e) {
            System.out.println("页数格式错误");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGeneral() {
        repaint();
    }

    @FXML
    private void handleFollowers() {
        vos.clear();//清空数组
        try {
            Iterator<UserVO> itr = bl.sortUser(User_Sort.Followers);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        page_max = (int) (vos.size() / 8);//计算最大页数
        maxPg.setText(String.valueOf(page_max));

        updatePage();

    }

    @FXML
    private void handleRepo() {
        vos.clear();//清空数组
        try {
            Iterator<UserVO> itr = bl.sortUser(User_Sort.HAS);
            while (itr.hasNext()) {
                vos.add(itr.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        page_max = (int) (vos.size() / 8);//计算最大页数
        maxPg.setText(String.valueOf(page_max));

        updatePage();

    }

    public void setKey(String key) {
        this.key = key;
    }
}
