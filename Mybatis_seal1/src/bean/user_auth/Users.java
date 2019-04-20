package bean.user_auth;

import java.util.Date;
import java.util.List;

public class Users {
	private Integer id;
    private String username;
    private String name;
    private String password;
    private String bumen;
    private Date createtime;
    private List<Roles> rolesList;
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
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public List<Roles> getRolesList() {
		return rolesList;
	}
	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}
    
	 @Override
	    public String toString() {
	        return "Users [id=" + id + ", username=" + username + ", name=" + name +  
	                " password=" + password + ", bumen=" + bumen + ", createtime=" + createtime
	                +  ", rolesList=" + rolesList + "]";
	    }

    
}
