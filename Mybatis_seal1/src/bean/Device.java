package bean;

import java.sql.Timestamp;

public class Device {

		private int id;
		private String shebeibianhao;
		private String shuoming;
		private Area   area;
		private Category  leixing;
		private String lururen;
		private Timestamp lurushijian;
		private String  beizhu;
		private String  url;
		
		
		public Device() {
			super();
		}
		
		
		
		public Device(String shebeibianhao, String shuoming, Area area,Category leixing,
				String lururen, Timestamp lurushijian, String beizhu,String url) {
			super();
			this.shebeibianhao = shebeibianhao;
			this.shuoming = shuoming;
			this.area = area;
			this.leixing=leixing;
			this.lururen = lururen;
			this.lurushijian = lurushijian;
			this.beizhu = beizhu;
			this.url=url;
		}


		
		public String getUrl() {
			return url;
		}



		public void setUrl(String url) {
			this.url = url;
		}



		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getShebeibianhao() {
			return shebeibianhao;
		}
		public void setShebeibianhao(String shebeibianhao) {
			this.shebeibianhao = shebeibianhao;
		}
		public String getShuoming() {
			return shuoming;
		}
		public void setShuoming(String shuoming) {
			this.shuoming = shuoming;
		}
		public Area getArea() {
			return area;
		}
		public void setArea(Area area) {
			this.area = area;
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
		public String getBeizhu() {
			return beizhu;
		}
		public void setBeizhu(String beizhu) {
			this.beizhu = beizhu;
		}



		public Category getLeixing() {
			return leixing;
		}



		public void setLeixing(Category leixing) {
			this.leixing = leixing;
		}
	
}
