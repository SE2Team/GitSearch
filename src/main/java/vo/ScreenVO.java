package vo;

public class ScreenVO {
	String time;
	String language;
	String category;
	public ScreenVO(String time,
	String language,
	String category){
		this.time=time;
		this.language=language;
		this.category=category;
	}
	
	public String getTime(){
		return this.time;
	}
	public String getLanguage(){
		return this.language;
	}
	public String getCategory(){
		return this.category;
	}
	
	public void setTime(String time){
		 this.time=time;
	}
	public  void setLanguage(String language){
		 this.language=language;
	}
	public void setCategory(String category){
		 this.category=category;
	}
}
