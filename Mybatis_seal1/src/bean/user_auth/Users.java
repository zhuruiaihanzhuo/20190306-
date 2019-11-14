package bean.user_auth;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Users {
	private Integer id;
    private String username;
    private String name;
    private String password;
    private String bumen;
    private  String lururen;
    private Timestamp createtime;
    private List<Roles> rolesList;
    
	public Users() {
		super();
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	
	public Users(String username, String name, String password, String bumen,
			String lururen, Timestamp createtime, List<Roles> rolesList) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.bumen = bumen;
		this.lururen = lururen;
		this.createtime = createtime;
		this.rolesList = rolesList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public List<Roles> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}
	
    
	 public String getLururen() {
		return lururen;
	}
	public void setLururen(String lururen) {
		this.lururen = lururen;
	}
	@Override
	    public String toString() {
	        return "Users [id=" + id + ", username=" + username + ", name=" + name +  
	                " password=" + password + ", bumen=" + bumen + ", createtime=" + createtime
	                +  ", rolesList=" + rolesList + " lururen=" + lururen + "]";
	    }
	
	

    
}
