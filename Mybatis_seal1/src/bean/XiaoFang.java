package bean;

import java.util.Date;

public class XiaoFang {
	private int id;
	private String jiancharen;
	private String bumen;
	private int device_id;
	private String sqshuliang;
	private String sdshuliang;
	private String beizhu;
	private Date date;
	private String shebeibianhao;
	
	
	

	
	
	public String getShebeibianhao() {
		return shebeibianhao;
	}





	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
	}





	public XiaoFang() {
		super();
	}
	




	public XiaoFang(String jiancharen, int device_id) {
		super();
		this.jiancharen = jiancharen;
		this.device_id = device_id;
	}














	public XiaoFang(String jiancharen, String bumen, int device_id,
			String sqshuliang, String sdshuliang, String beizhu, Date date,String shebeibianhao) {
		super();
		this.jiancharen = jiancharen;
		this.bumen = bumen;
		this.device_id = device_id;
		this.sqshuliang = sqshuliang;
		this.sdshuliang = sdshuliang;
		this.beizhu = beizhu;
		this.date = date;
		this.shebeibianhao=shebeibianhao;
	}





	public String getSqshuliang() {
		return sqshuliang;
	}

	public void setSqshuliang(String sqshuliang) {
		this.sqshuliang = sqshuliang;
	}

	public String getSdshuliang() {
		return sdshuliang;
	}

	public void setSdshuliang(String sdshuliang) {
		this.sdshuliang = sdshuliang;
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
	

	public int getDevice_id() {
		return device_id;
	}





	public void setDevice_id(int device_id) {
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
