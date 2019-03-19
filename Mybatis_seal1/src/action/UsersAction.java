package action;

import java.util.List;

import bean.Users;
import dao.UsersDAO;
import dao.impl.UserDAOImpl;



public class UsersAction extends SuperAction {

	public String  qurey() {
		
		UsersDAO udao=new UserDAOImpl();
		String username  =request.getParameter("username");
		String password =request.getParameter("password");
		Users users=new Users();
		users.setUsername(username);
		users.setPassword(password);
		boolean resu =udao.usersLogin(users);
		System.out.println(resu);
		if (resu==true) {
		
			return "query_success";
		}
		else {
			return "query_error";
		}
	}
	
	
}
