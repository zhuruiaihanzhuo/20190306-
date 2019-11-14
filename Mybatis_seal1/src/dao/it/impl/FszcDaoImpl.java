package dao.it.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.it.Fszc;
import bean.zk.Drgfgzx1;
import dao.it.FszcDao;
import db.DBA;

public class FszcDaoImpl implements FszcDao {

	@Override
	public boolean addFszc(Fszc fszc) {
	DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("Fszc.add",fszc);
		
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
	public List<Fszc> query() {
		DBA dba=new DBA();
		List <Fszc> fszcList= new ArrayList<Fszc>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		fszcList=sqlSession.selectList("Fszc.queryAll");
		
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
		
		return fszcList;
	}
	
	public List<Fszc> queryByDepartment(String department ) {
		DBA dba=new DBA();
		List <Fszc> fszcList= new ArrayList<Fszc>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		fszcList=sqlSession.selectList("Fszc.queryByDepartment",department);
		
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
		
		return fszcList;
	}
	
	
	
	}


