package dataService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import po.RepositoryPO;
import po.StaIntPO;
import po.StaStrPO;
import po.StatisticsPO;

public interface StatisticsDataService {
	
	/**
	 * 
	 * @return
	 * list中包含3个int值
	 * 分别表示star在0-1000
	 * 1001-2000
	 * over2000
	 * @throws IOException 
	 */
	public StaStrPO getStar() throws IOException;
	
	public StatisticsPO getScores(RepositoryPO po) throws IOException;
	
	/**
	 * 
	 * @return
	 * list中包含3个int值
	 * 分别表示fork在0-100
	 * 100-1000
	 * over1000
	 * @throws IOException 
	 */
	public StaStrPO getForks() throws IOException;
	
	/*
	 * list中包含4个值，分别是从07到10每年创建的项目数
	 * maxYear:20100721
	 * minYear:20071029
	 */
	public StaStrPO getRepoCreated() throws IOException;
	
	/**
	 *
	 * String language
	 * Integer:语言使用次数
	 * @throws IOException 
	 * 
	 *
	 */
	public StaStrPO getLanguage() throws IOException;
	
	/**
	 * list中包含9个值，分别是从07到15每年创建的用户数
	 * maxYear:20151108
	 * minYear:20071020
	 * @return
	 * @throws IOException 
	 */
	public StaStrPO  getUserCreated() throws IOException;
	
	/**
	 * 
	 * 
	 * @return 用户类型    数量
	 * @throws IOException
	 */
	public StaStrPO getUserType() throws IOException; 
	
	/**
	 * 
	 * @return 用户拥有的项目数  用户数量
	 */
	public StaIntPO getUserHas();
	
	/**
	 * 
	 * @return 用户相关的项目数  用户数量
	 */
	public StaIntPO getUserRelated();
	
	/**
	 * 
	 * @return 公司名  用户数
	 * @throws IOException 
	 */
	public StaStrPO getCompany() throws IOException;
	
	public Integer getHasNum(String name);
	
	public StaStrPO getCollaborator();
	
	public StaStrPO getContributor();
}
