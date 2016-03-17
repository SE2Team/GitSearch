package businesslogicService;

import java.util.Observable;
import vo.StatisticsVO;
import javafx.collections.ObservableList;
/** 
 * @author 
 * @date 
2016年3月16日 
下午4:33:10 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 *@throws 异常类及抛出条件
 */
public interface StatisticsBLService {

	ObservableList<StatisticsVO> getScore();
}
