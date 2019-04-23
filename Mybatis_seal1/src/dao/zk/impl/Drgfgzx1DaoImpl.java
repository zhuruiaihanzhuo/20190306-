package dao.zk.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import bean.zk.Drgfgzx1;
import dao.zk.Drgfgzx1Dao;
import db.DBA;

public class Drgfgzx1DaoImpl implements Drgfgzx1Dao {

	@Override
	public boolean add(Drgfgzx1 drgfgzx1) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("Drgfgzx1.add",drgfgzx1);
		
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
