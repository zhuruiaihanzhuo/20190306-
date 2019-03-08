package bean;

import java.util.Date;

public class XiaoFang {
	private int id;
	private String jiancharen;
	private String bumen;
	private String shebeibianhao;
	private String sqshuliang;
	private String sdshuliang;
	private String beizhu;
	private Date date;
	
	
	

	
	
	public XiaoFang() {
		super();
	}
	




	public XiaoFang(String jiancharen, String shebeibianhao) {
		super();
		this.jiancharen = jiancharen;
		this.shebeibianhao = shebeibianhao;
	}














	public XiaoFang(String jiancharen, String bumen, String shebeibianhao,
			String sqshuliang, String sdshuliang, String beizhu, Date date) {
		super();
		this.jiancharen = jiancharen;
		this.bumen = bumen;
		this.shebeibianhao = shebeibianhao;
		this.sqshuliang = sqshuliang;
		this.sdshuliang = sdshuliang;
		this.beizhu = beizhu;
		this.date = date;
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
	public String getShebeibianhao() {
		return shebeibianhao;
	}
	public void setShebeibianhao(String shebeibianhao) {
		this.shebeibianhao = shebeibianhao;
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
