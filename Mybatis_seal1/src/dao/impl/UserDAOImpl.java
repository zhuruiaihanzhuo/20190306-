package dao.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Device;
import bean.MieHuo;
import bean.user_auth.Permissions;
import bean.user_auth.Users;
import bean.user_auth.Roles;
import dao.UsersDAO;
import db.DBA;



public class UserDAOImpl implements UsersDAO {

	
	
	public boolean addUser(Users users) {
		//事物对象
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		
		try {

			sqlSession=	dba.getSqlSession();
			
			//通过sqlSession执行sql语句；
		 sqlSession.update("User_auth.add",users);
		
			
		 sqlSession.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}	
			}
		return true;			
}
	
	
	
	

	public Users usersLogin(Users users) {
		//事物对象
		DBA dba=new DBA();
		Users users2=new Users();
		SqlSession sqlSession=null;
		
		try {

			sqlSession=	dba.getSqlSession();
			System.out.println(users.getPassword());
			//通过sqlSession执行sql语句；
		 users2=sqlSession.selectOne("User_auth.select",users);
		
			
		 sqlSession.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}	
			}
		if (users2!=null) {
			System.out.println(users2.getName());
			return users2		;
		}else {
			
			return null;
		}
			
}
	
	public boolean update(Users users) {
		//事物对象
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		
		try {

			sqlSession=	dba.getSqlSession();
			
			//通过sqlSession执行sql语句；
		 sqlSession.update("User_auth.update",users);
		
			
		 sqlSession.commit();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}	
			}
		return true;			
}
	
	
	
	

	@Override
	public List<Roles> selectRoles(Users users) {
		DBA dba=new DBA();
	
		 List<Roles> rolesList= new ArrayList<Roles>();
		SqlSession sqlSession=null;
		
		try {
			
			/*Session session =MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		
			tx=session.beginTransaction();
			
			hql="from Users where username=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, u.getUsername());
			query.setParameter(1, u.getPassword());
			List list= query.list();
			tx.commit();//提交事务
			if (list.size()>0) {
				return true		;
			}else {
				System.out.println("zaizhema");
				return false;
			}
		
		} catch (Exception e) {
		e.printStackTrace();*/
			sqlSession=	dba.getSqlSession();
			System.out.println(users.getPassword());
			//通过sqlSession执行sql语句；
		Users users2=sqlSession.selectOne("User_auth.findUsersByName",users);
		int id=users2.getId();
		rolesList=sqlSession.selectList("User_auth.selectAllRoles", id);
		System.out.println(rolesList);
			/*for (Roles roles : rolesList) {
				for (Permissions permissions : roles.getPermissionsList()) {
					System.out.println(permissions.getUrl());
				}
			}*/
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}	;
				
	}
		return rolesList;
}

	@Override
	public List<Users> selectAll() {
		//事物对象
				DBA dba=new DBA();
				 List<Users> userList= new ArrayList<Users>();
				SqlSession sqlSession=null;
				
				try {

					sqlSession=	dba.getSqlSession();
			
					//通过sqlSession执行sql语句；
				 userList=sqlSession.selectList("User_auth.selectAll");
				
					
				 sqlSession.commit();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					} finally{
						if (sqlSession !=null) {
							sqlSession.close();
						}	
					}
				
				return	 userList;
				
	}


}