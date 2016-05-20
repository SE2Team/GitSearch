package presentation.Trending;

import businesslogic.RepositoryBL.RepositoryController;
import businesslogic.userBL.UserController;
import businesslogicService.RepositoryBLService;
import businesslogicService.UserBLService;
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
import vo.UserVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2016/5/3.
 */
public class TrendingController implements MyController{

    @FXML
    private ComboBox TimeCombo;

//    @FXML
//    private ComboBox LangCombo;

    @FXML
    private FlowPane RepoPane;

    @FXML
    private FlowPane UserPane;

    @FXML
    private FlowPane languagePane;

    private RepositoryBLService rbl = new RepositoryController();
    private ArrayList<RepositoryVO> rvos = new ArrayList<RepositoryVO>();
    private UserBLService ubl = new UserController();
    private ArrayList<UserVO> uvos = new ArrayList<UserVO>();
    private ArrayList<ToggleButton> language = new ArrayList<>();
    private ToggleGroup langGroup = new ToggleGroup();

    /**
     * 项目翻页部件
     */
    @FXML
    private Button rpgUp;
    @FXML
    private Button rpgDn;
    @FXML
    private Button rfpg;
    @FXML
    private Button rlpg;
    @FXML
    private TextField rpgNum;
    @FXML
    private Label r_maxPg;

    /**
     * 用户翻页部件
     */
    @FXML
    private Button UserpgUp;
    @FXML
    private Button UserpgDn;
    @FXML
    private Button Userfpg;
    @FXML
    private Button Userlpg;
    @FXML
    private TextField UserpgNum;
    @FXML
    private Label u_maxPg;

    private FXUITest fxuiTest;
    private int r_pageMax=0;//项目最大页数
    private int u_pageMax=0;//用户最大页数
    private int r_page = 1;
    private int u_page = 1;
    private String key = "";//搜索关键字

    public void initialize() {
        TimeCombo.getItems().addAll("today","this week");
        initFilters();
        langGroup.getToggles().addAll(language);
        rpgNum.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    handle_rPgNum();
                }
            }
        });

        UserpgNum.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    handle_uPgNum();
                }
            }
        });
    }

    public void setFxui(FXUITest fxui) {
        this.fxuiTest = fxui;
    }

    public void repaint() {
        //项目
        rvos.clear();
        try{
            Iterator<RepositoryVO> r_itr = rbl.Search("");
            while(r_itr.hasNext()){
                rvos.add(r_itr.next());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        updateRepMaxPages(rvos.size());
        update_rPage();

        //用户
        uvos.clear();
        try{
            Iterator<UserVO> u_itr = ubl.search("");
            while(u_itr.hasNext()){
                uvos.add(u_itr.next());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        updateUserMaxPages(uvos.size());
        update_uPage();
    }

    /**
     * 获取项目的子面板
     * @param vo
     * @return
     */
    private AnchorPane getRepoSub(RepositoryVO vo) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubRepoTrend.fxml"));
        AnchorPane anchorPane = new AnchorPane();
        SubRepoTrendController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();

        return anchorPane;
    }

    /**
     * 获取用户的子面板
     * @param vo
     * @return
     */
    private AnchorPane getUserSub(UserVO vo) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("SubUserTrend.fxml"));
        AnchorPane anchorPane = new AnchorPane();
        SubUserTrendController controller = loader.getController();

        controller.setFxui(fxuiTest);
        controller.setVo(vo);
        controller.repaint();

        return anchorPane;
    }

    //项目翻页部件
    @FXML
    private void handle_rPgup(){
        if(r_page<=1){
            return;
        }else{
            r_page--;
            update_rPage();
        }

    }
    @FXML
    private void handle_rPgDn(){
        if (r_page + 1 > r_pageMax) {
            return;
        } else {
            r_page++;
            update_rPage();
        }
    }
    @FXML
    private void handle_rFpg(){
        r_page = 1;
        update_rPage();
    }
    @FXML
    private void handle_rLpg(){
        r_page = r_pageMax;
        update_rPage();
    }
    @FXML
    private void handle_rPgNum(){
        try {
            if (Integer.parseInt(rpgNum.getText()) > r_pageMax || Integer.parseInt(rpgNum.getText()) <= 0)
                throw new NumberFormatException();
            r_page = Integer.parseInt(rpgNum.getText());
            update_rPage();
        } catch (NumberFormatException e) {
            System.out.println("页数格式错误");
            e.printStackTrace();
        }
    }//结束

    //用户翻页部件
    @FXML
    private void handle_uPgup(){
        if(u_page<=1){
            return;
        }else{
            u_page--;
            update_uPage();
        }
    }
    @FXML
    private void handle_uPgDn(){
        if (u_page + 1 > u_pageMax) {
            return;
        } else {
            u_page++;
            update_uPage();
        }
    }
    @FXML
    private void handle_uFpg(){
        u_page = 1;
        update_uPage();
    }
    @FXML
    private void handle_uLpg(){
        u_page = u_pageMax;
        update_uPage();
    }
    @FXML
    private void handle_uPgNum(){
        try {
            if (Integer.parseInt(UserpgNum.getText()) > u_pageMax || Integer.parseInt(UserpgNum.getText()) <= 0)
                throw new NumberFormatException();
            u_page = Integer.parseInt(UserpgNum.getText());
            update_uPage();
        } catch (NumberFormatException e) {
            System.out.println("页数格式错误");
            e.printStackTrace();
        }
    }//结束


    /**
     * 项目翻页
     */
    private void update_rPage(){
        /**
         * remove it's small pane
         */
        if(RepoPane.getChildren().size()!=0){
            RepoPane.getChildren().remove(0,RepoPane.getChildren().size());
        }

        for(int i=0;i<6;i++){
            if (((r_page - 1) * 6 + i) >= rvos.size()) {
                break;
            }
            try {
                RepoPane.getChildren().add(getRepoSub(rvos.get((r_page - 1) * 6 + i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        rpgNum.setText(String.valueOf(r_page));
    }

    /**
     * 用户翻页
     */
    private void update_uPage(){
        /**
         * remove it's small pane
         */
        if(UserPane.getChildren().size()!=0){
            UserPane.getChildren().remove(0,UserPane.getChildren().size());
        }

        for(int i=0;i<6;i++){
            if (((u_page - 1) * 6 + i) >= uvos.size()) {
                break;
            }
            try {
                UserPane.getChildren().add(getUserSub(uvos.get((u_page - 1) * 6 + i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UserpgNum.setText(String.valueOf(u_page));
    }
    /**
     * 更新项目的最大页数
     * @param i
     */
    private void updateRepMaxPages(int i){
        if (i == 0) {
            r_pageMax = 0;
        } else {

            r_pageMax = (int) (i / 6 );//计算最大页数
            if (i%6!=0)
                r_pageMax++;
            if (r_pageMax == 0) {
                r_pageMax = 1;
            }
        }
        r_maxPg.setText(String.valueOf(r_pageMax));
    }

    /**
     * 更新用户的最大页数
     * @param i
     */
    private void updateUserMaxPages(int i){
        if (i == 0) {
            u_pageMax = 0;
        } else {

            u_pageMax = (int) (i / 6 );//计算最大页数
            if (i%6!=0)
                u_pageMax++;
            if (u_pageMax == 0) {
                u_pageMax = 1;
            }
        }
        u_maxPg.setText(String.valueOf(u_pageMax));
    }

    //TODO
    private void handleScreen(String str){
        rvos.clear();
        Iterator<RepositoryVO> RepItr = null;
        try {
            String langtxt = "";
            if (langGroup.getSelectedToggle() != null) {
                ToggleButton langB = (ToggleButton) langGroup.getSelectedToggle().selectedProperty().getBean();
                langtxt = langB.getText();
            }
            ScreenVO vo = new ScreenVO(langtxt,"","");
            RepItr = rbl.screen(vo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (RepItr.hasNext()) {
            rvos.add(RepItr.next());
        }
        updateRepMaxPages(rvos.size());
        r_page=1;
        update_rPage();

//        uvos.clear();
//        Iterator<UserVO> UserItr = null;
//
//        while (UserItr.hasNext()){
//            uvos.add(UserItr.next());
//        }
//        updateUserMaxPages(uvos.size());
//        u_page = 1;
//        update_uPage();
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 初始化筛选组件
     */
    public void initFilters(){
        for(Node n: languagePane.getChildren()){
            final ToggleButton t = (ToggleButton) n;
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(t.isSelected()==false)
                        handleScreen("");
                    else {
                        handleScreen(t.getText());
                    }

                }
            });
            language.add(t);
        }
    }
}
