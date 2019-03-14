package bean;

import java.sql.Timestamp;

public class Area {
		private int id;
		private  String  lururen;
		private  String  quyudaima;
		private  String  shuoming;
		private  String   zerenbumen;
		private  Timestamp   lurushijian;
		private  String  beizhu;
		

		public Area() {
			super();
		}
		
		
		
		
		
		
		public Area(String lururen, String quyudaima, String shuoming,String zerenbumen,
				Timestamp lurushijian, String beizhu) {
			super();
			this.lururen = lururen;
			this.quyudaima = quyudaima;
			this.shuoming = shuoming;
			this.zerenbumen=zerenbumen;
			this.lurushijian = lurushijian;
			this.beizhu = beizhu;
		}






		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLururen() {
			return lururen;
		}
		public void setLururen(String lururen) {
			this.lururen = lururen;
		}
		public String getQuyudaima() {
			return quyudaima;
		}
		public void setQuyudaima(String quyudaima) {
			this.quyudaima = quyudaima;
		}
		public String getShuoming() {
			return shuoming;
		}
		public void setShuoming(String shuoming) {
			this.shuoming = shuoming;
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






		public String getZerenbumen() {
			return zerenbumen;
		}






		public void setZerenbumen(String zerenbumen) {
			this.zerenbumen = zerenbumen;
		}
	
		
	
}
