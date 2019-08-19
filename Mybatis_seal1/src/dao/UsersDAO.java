package dao;

import java.util.List;

import bean.user_auth.Users;
import bean.user_auth.Roles;

//用户业务逻辑接口
public interface UsersDAO {
//用户登录方法
	public Users usersLogin(Users users);
	public List<Roles> selectRoles(Users users) ;
	public boolean update(Users users);
	
}
