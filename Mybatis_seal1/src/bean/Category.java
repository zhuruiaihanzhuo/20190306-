package bean;

import java.sql.Timestamp;

public class Category {
	private int id;
	private String leibie;
	private String  zerendanwei;
	private String  yuanyin;
	private Timestamp lurushijian;
	private String   beizhu;
	
	
	
	
	
	
	public Category() {
		super();
	}
	
	
	
	
	public Category(String leibie, String zerendanwei, String yuanyin,
			Timestamp lurushijian, String beizhu) {
		super();
		this.leibie = leibie;
		this.zerendanwei = zerendanwei;
		this.yuanyin = yuanyin;
		this.lurushijian = lurushijian;
		this.beizhu = beizhu;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLeibie() {
		return leibie;
	}
	public void setLeibie(String leibie) {
		this.leibie = leibie;
	}
	public String getZerendanwei() {
		return zerendanwei;
	}
	public void setZerendanwei(String zerendanwei) {
		this.zerendanwei = zerendanwei;
	}
	public String getYuanyin() {
		return yuanyin;
	}
	public void setYuanyin(String yuanyin) {
		this.yuanyin = yuanyin;
	}
	public Timestamp getLurushijian() {
		return lurushijian;
	}
	public void setLurushijian(Timestamp lurushijian) {
		this.lurushijian = lurushijian;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}  
	
	
}
