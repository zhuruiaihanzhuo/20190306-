package bean.gy;

import java.sql.Timestamp;

public class MojuOfDelete {
	private  int id;
	private  String bianhao;
	private  String shuoming;
	private  String neirong;
	private  String shanchuren;
    private	 Timestamp shanchushijian;
    
    
    
    
    
    
    
	public MojuOfDelete() {
		super();
	}







	public MojuOfDelete(String bianhao, String shuoming, String neirong,
			String shanchuren, Timestamp shanchushijian) {
		super();
		this.bianhao = bianhao;
		this.shuoming = shuoming;
		this.neirong = neirong;
		this.shanchuren = shanchuren;
		this.shanchushijian = shanchushijian;
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getBianhao() {
		return bianhao;
	}







	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}







	public String getShuoming() {
		return shuoming;
	}







	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}







	public String getNeirong() {
		return neirong;
	}







	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}







	public String getShanchuren() {
		return shanchuren;
	}







	public void setShanchuren(String shanchuren) {
		this.shanchuren = shanchuren;
	}







	public Timestamp getShanchushijian() {
		return shanchushijian;
	}







	public void setShanchushijian(Timestamp shanchushijian) {
		this.shanchushijian = shanchushijian;
	}
	
	
	
	

		
		
		
	
	
	
}
