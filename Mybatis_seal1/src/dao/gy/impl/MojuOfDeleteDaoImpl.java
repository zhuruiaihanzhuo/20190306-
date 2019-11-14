package dao.gy.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import bean.gy.MojuOfDelete;
import dao.gy.MojuOfDeleteDao;
import db.DBA;

public class MojuOfDeleteDaoImpl implements MojuOfDeleteDao {

	@Override
	public boolean add(MojuOfDelete moju) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("MojuOfDelete.add",moju);
		
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

}
