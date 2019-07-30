package action;


import java.sql.Timestamp;
import java.util.List;






import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import net.sf.json.JsonConfig;
import bean.user_auth.Users;
import bean.user_auth.Roles;
import dao.UsersDAO;
import dao.impl.UserDAOImpl;



public class UsersAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Object object;;
	private Object object2;
	
	public Object getObject2() {
		return object2;
	}


	public void setObject2(Object object2) {
		this.object2 = object2;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	
	
	
	public String  queryAuth() {
		
		UsersDAO udao=new UserDAOImpl();
		String username  =request.getParameter("username");
		
		Users users=new Users();
		users.setUsername(username);
		
		/*boolean resu =udao.usersLogin(users);
		System.out.println(resu);
		if (resu==true) {
		
			return "query_success";
		}
		else {
			return "query_error";
		}*/
		List<Roles> rolesList= udao.selectRoles(users);
		
		
		JSONObject obj=new JSONObject();
		obj.put("data",rolesList );
		System.out.println(obj);
	
		this.object=obj;
		
		if (rolesList.size()>0) {
			
			
			return "queryAuth_success";
		}
		else {
			return "query_error";
		}
		
	}
	
	
public String  query() {
		
		UsersDAO udao=new UserDAOImpl();
		String username  =request.getParameter("username");
		String password =request.getParameter("password");
		Users users=new Users();
		users.setUsername(username);
		users.setPassword(password);
		Users resu =udao.usersLogin(users);
		System.out.println(resu);
		if (resu!=null) {
			session.setAttribute("bumen", resu.getBumen());
			session.setAttribute("user", username);
			session.setAttribute("name", resu.getName());
			return "query_success";
		}
		else {
			return "query_error";
		}
	
	}
	
public String  query_app() {
	
	UsersDAO udao=new UserDAOImpl();
	String username  =request.getParameter("username");
	String password =request.getParameter("password");
	Users users=new Users();
	users.setUsername(username);
	users.setPassword(password);
	Users resu =udao.usersLogin(users);
	JsonConfig jsonConfig = new JsonConfig();
	jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
	JSONArray js=JSONArray.fromObject(resu,jsonConfig);
	JSONObject obj=new JSONObject();
	obj.put("data", js.toString());
	System.out.println(obj);
	System.out.println(resu);
	if (resu!=null) {
		session.setAttribute("bumen", resu.getBumen());
		session.setAttribute("user", username);
		session.setAttribute("name", resu.getName());
		System.out.println("daodizahuishi");
		this.object2=obj;
		return "query_success";
	}
	else{
		return "query_error";
	}
	
	

	
}

}
