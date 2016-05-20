package data;


public class GetJDBC {
	public static JDBCHelper helper=null;
	
	public static JDBCHelper getJDBCHelper(){
		if(helper==null){
			helper= new JDBCHelper();
		}
		return helper;
	}
}
