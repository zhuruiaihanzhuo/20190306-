package bean;

import java.util.Date;

public class MieHuo {
	private int id;
	private String jiancharen;
	private String bumen;
	private Device device_id;
	private String shuliang;
	private String beizhu;
	private Date date;


	public MieHuo() {
		super();
	}
	

	
	public MieHuo(String jiancharen) {
		super();
		this.jiancharen = jiancharen;
		
	}









	public MieHuo(String jiancharen, String bumen,Device device_id,
			String shuliang, String beizhu, Date date) {
		super();
		this.jiancharen = jiancharen;
		this.bumen = bumen;
		this.device_id=device_id;
		this.shuliang = shuliang;
		this.beizhu = beizhu;
		this.date = date;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJiancharen() {
		return jiancharen;
	}
	public void setJiancharen(String jiancharen) {
		this.jiancharen = jiancharen;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
/*	public String getShebeibianhao() {
		return shebeibianhao;
	}
	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}*/
	public String getShuliang() {
		return shuliang;
	}
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	public Device getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Device device_id) {
		this.device_id = device_id;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
