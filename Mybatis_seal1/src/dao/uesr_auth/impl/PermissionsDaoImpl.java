package dao.uesr_auth.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Area;
import bean.user_auth.Permissions;
import dao.uesr_auth.PermissionsDao;
import db.DBA;

public class PermissionsDaoImpl implements PermissionsDao {

	@Override
	public boolean addPermissions(Permissions permissions) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("User_auth.PermissionsAdd",permissions);
		
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
	public List<Permissions> qurey() {
	
			DBA dba=new DBA();
			List <Permissions> permissionsList= new ArrayList<Permissions>();
			SqlSession sqlSession=null;
			try {
			
			sqlSession=	dba.getSqlSession();
			
			//通过sqlSession执行sql语句；
			permissionsList=sqlSession.selectList("User_auth.selectPermissions");
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				if (sqlSession !=null) {
					sqlSession.close();
				}
				
			}
		
			
			return permissionsList;
	}

}
