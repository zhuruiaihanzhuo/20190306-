package dao.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.MieHuo;

import dao.MieHuoDao;
import db.DBA;

public class MieHuoDaoImpl implements MieHuoDao {

	@Override
	public boolean addMieHuo(MieHuo mHuo) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("MieHuo.add",mHuo);
		
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
	public List<MieHuo> queryAll(String jiancharen, String shebeibianhao) {
		
		DBA dba=new DBA();
		List <MieHuo> mieHuoList= new ArrayList<MieHuo>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		MieHuo mh=new MieHuo(jiancharen);
		//通过sqlSession执行sql语句；
		mieHuoList=sqlSession.selectList("MieHuo.queryAll",mh);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
		for (MieHuo mieHuo : mieHuoList) {
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	         
			
		}
		
		return mieHuoList;
	}



	@Override
	public int qureyByDate(String shebeibianhao) {
		DBA dba=new DBA();
		List <MieHuo> mieHuoList= new ArrayList<MieHuo>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		mieHuoList=sqlSession.selectList("MieHuo.qureyByDate",shebeibianhao);
		System.out.println(mieHuoList.size()+"55555555555555555555555555555555");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
		
		if (mieHuoList.size()>0) {
			return 1;
		} else {
			
		}
		return -1;
	}

}
