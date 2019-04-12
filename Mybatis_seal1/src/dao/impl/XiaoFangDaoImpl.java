package dao.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.MieHuo;
import bean.XiaoFang;
import dao.XiaoFangDao;
import db.DBA;

public class XiaoFangDaoImpl implements XiaoFangDao {

	@Override
	public boolean addXiaoFang(XiaoFang xFang) {
			DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		System.out.println(xFang.getBeizhu()+"-------");
		//通过sqlSession执行sql语句；
		sqlSession.insert("XiaoFang.add",xFang);
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
	public List<XiaoFang> queryAll() {
	
		DBA dba=new DBA();
		List <XiaoFang> xiaoFangList= new ArrayList<XiaoFang>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		xiaoFangList=sqlSession.selectList("XiaoFang.queryAll");
		
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
		
		return xiaoFangList;
	}

	@Override
	public int qureyByDate(String shebeibianhao) {
		DBA dba=new DBA();
		List <XiaoFang> mieHuoList= new ArrayList<XiaoFang>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		mieHuoList=sqlSession.selectList("XiaoFang.qureyByDate",shebeibianhao);
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
			return -1;
		}
		
	}

}
