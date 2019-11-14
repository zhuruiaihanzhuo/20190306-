package bean.it;

import java.sql.Timestamp;
import java.util.Date;

import bean.Category;
public class Fszc {

	private int id;
	private String  department;//部门
	private String office;//科室
	private String  category;//设备类型
	private String  brand;//设备品牌
	private String  type;//设备型号
	private String  ccNumber;//出厂编号
	private String zcNumber;//资产编号
	private String  personIC;//责任人
	private String  personCY;//曾用人
	private String  area;//现存地点
	private String  zpCount;//自盘数量
	private String state;//使用状态
	private String  newfcNumber;//新防拆标签嘛
	private String  admin;//硬件管理员
	private String  wxNumber;//维修防拆标签吗
	private String  wxPerson;//维修人员
	private String  remarks;//备注
	private String  lururen;
	private Timestamp  lurushijian;
	
	
	
	
	
	public Fszc() {
		super();
	}
	
	
	public Fszc(String department, String office, String category,
			String brand, String type, String ccNumber, String zcNumber,
			String personIC, String personCY, String area, String zpCount,
			String state, String newfcNumber, String admin, String wxNumber,
			String wxPerson, String remarks, String lururen, Timestamp lurushijian) {
		super();
		this.department = department;
		this.office = office;
		this.category = category;
		this.brand = brand;
		this.type = type;
		this.ccNumber = ccNumber;
		this.zcNumber = zcNumber;
		this.personIC = personIC;
		this.personCY = personCY;
		this.area = area;
		this.zpCount = zpCount;
		this.state = state;
		this.newfcNumber = newfcNumber;
		this.admin = admin;
		this.wxNumber = wxNumber;
		this.wxPerson = wxPerson;
		this.remarks = remarks;
		this.lururen = lururen;
		this.lurushijian = lurushijian;
	}


	public Fszc(int id, String department, String office, String category,
			String brand, String type, String ccNumber, String zcNumber,
			String personIC, String personCY, String area, String zpCount,
			String state, String newfcNumber, String admin, String wxNumber,
			String wxPerson, String remarks, String lururen, Timestamp lurushijian) {
		super();
		this.id = id;
		this.department = department;
		this.office = office;
		this.category = category;
		this.brand = brand;
		this.type = type;
		this.ccNumber = ccNumber;
		this.zcNumber = zcNumber;
		this.personIC = personIC;
		this.personCY = personCY;
		this.area = area;
		this.zpCount = zpCount;
		this.state = state;
		this.newfcNumber = newfcNumber;
		this.admin = admin;
		this.wxNumber = wxNumber;
		this.wxPerson = wxPerson;
		this.remarks = remarks;
		this.lururen = lururen;
		this.lurushijian = lurushijian;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Fszc [id=" + id + ", department=" + department + ", office="
				+ office + ", category=" + category + ", brand=" + brand
				+ ", type=" + type + ", ccNumber=" + ccNumber + ", zcNumber="
				+ zcNumber + ", personIC=" + personIC + ", personCY="
				+ personCY + ", area=" + area + ", zpCount=" + zpCount
				+ ", state=" + state + ", newfcNumber=" + newfcNumber
				+ ", admin=" + admin + ", wxNumber=" + wxNumber + ", wxPerson="
				+ wxPerson + ", remarks=" + remarks + ", lururen=" + lururen
				+ ", lurushijian=" + lurushijian + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getZcNumber() {
		return zcNumber;
	}
	public void setZcNumber(String zcNumber) {
		this.zcNumber = zcNumber;
	}
	public String getPersonIC() {
		return personIC;
	}
	public void setPersonIC(String personIC) {
		this.personIC = personIC;
	}
	public String getPersonCY() {
		return personCY;
	}
	public void setPersonCY(String personCY) {
		this.personCY = personCY;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getZpCount() {
		return zpCount;
	}
	public void setZpCount(String zpCount) {
		this.zpCount = zpCount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNewfcNumber() {
		return newfcNumber;
	}
	public void setNewfcNumber(String newfcNumber) {
		this.newfcNumber = newfcNumber;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getWxNumber() {
		return wxNumber;
	}
	public void setWxNumber(String wxNumber) {
		this.wxNumber = wxNumber;
	}
	public String getWxPerson() {
		return wxPerson;
	}
	public void setWxPerson(String wxPerson) {
		this.wxPerson = wxPerson;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	

	
	
	
	
	
	
}
