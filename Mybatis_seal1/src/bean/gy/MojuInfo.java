package bean.gy;

import java.sql.Timestamp;

public class MojuInfo {
	private  int id;
	private  String bianhao;
	private  String shuoming;
	private  String neirong;
	private  String lururen;
	private	 Timestamp lurushijian;
	private  String genggairen;
    private	 Timestamp genggaishijian;
    
    
    
    
    
    
    
	public MojuInfo() {
		super();
	}
	
	
	
	
	
	
	public MojuInfo(String bianhao, String shuoming, String neirong,
			String lururen, Timestamp lurushijian) {
		super();
		this.bianhao = bianhao;
		this.shuoming = shuoming;
		this.neirong = neirong;
		this.lururen = lururen;
		this.lurushijian = lurushijian;
	}






	public MojuInfo(String bianhao, String shuoming, String neirong,
			String lururen, Timestamp lurushijian, String genggairen,
			Timestamp genggaishijian) {
		super();
		this.bianhao = bianhao;
		this.shuoming = shuoming;
		this.neirong = neirong;
		this.lururen = lururen;
		this.lurushijian = lurushijian;
		this.genggairen = genggairen;
		this.genggaishijian = genggaishijian;
	}






	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
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
	public String getLururen() {
		return lururen;
	}
	public void setLururen(String lururen) {
		this.lururen = lururen;
	}
	public Timestamp getLurushijian() {
		return lurushijian;
	}
	public void setLurushijian(Timestamp lurushijian) {
		this.lurushijian = lurushijian;
	}
	public String getGenggairen() {
		return genggairen;
	}
	public void setGenggairen(String genggairen) {
		this.genggairen = genggairen;
	}
	public Timestamp getGenggaishijian() {
		return genggaishijian;
	}
	public void setGenggaishijian(Timestamp genggaishijian) {
		this.genggaishijian = genggaishijian;
	}
		
		
		
	
	
	
}
