package dao.zk.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.XiaoFang;
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

	@Override
	public List<Drgfgzx1> queryAll() {
		DBA dba=new DBA();
		List <Drgfgzx1> drgfgzx1List= new ArrayList<Drgfgzx1>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		drgfgzx1List=sqlSession.selectList("Drgfgzx1.queryAll");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	/*	for (XiaoFang xiaoFang : xiaoFangList) {
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	         
			System.out.println(sdf.format(xiaoFang.getDate()));
		}*/
		
		return drgfgzx1List;
	}

}
