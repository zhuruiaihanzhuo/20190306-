package dao.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Device;
import bean.MieHuo;
import bean.Users;
import dao.UsersDAO;
import db.DBA;



public class UserDAOImpl implements UsersDAO {


	public boolean usersLogin(Users users) {
		//事物对象
		DBA dba=new DBA();
		List<Users>  list =new ArrayList<Users>();
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
		 list=sqlSession.selectList("Users.select",users);
		
			
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}	
			}
		if (list.size()>0) {
			return true		;
		}else {
			System.out.println(list.size());
			return false;
		}
}
}