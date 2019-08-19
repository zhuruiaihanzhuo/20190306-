package dao.gy.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;






import bean.gy.MojuInfo;
import dao.gy.MojuInfoDao;
import db.DBA;

public class Moju_infoDaoImpl implements MojuInfoDao {


	public boolean addMoju(MojuInfo moju) {
	
	DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("MojuInfo.add",moju);
		
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
	public List<MojuInfo> queryAll() {
		DBA dba=new DBA();
		List <MojuInfo> mojuList= new ArrayList<MojuInfo>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		mojuList=sqlSession.selectList("MojuInfo.queryAll");
		System.out.println(mojuList+"kkkkkkkkkkkkkkkkkkkk");
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
		
		return mojuList;
	}

	@Override
	public List<MojuInfo> queryByBianhao(String bianhao) {
		DBA dba=new DBA();
		List <MojuInfo> mojuList= new ArrayList<MojuInfo>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		mojuList=sqlSession.selectList("MojuInfo.queryByBianhao",bianhao);
		System.out.println(mojuList+"kkkkkkkkkkkkkkkkkkkk");
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
		
		return mojuList;
	}
	
	public int checkByBianhao(String bianhao) {
		DBA dba=new DBA();
		List <MojuInfo> mojuList= new ArrayList<MojuInfo>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		mojuList=sqlSession.selectList("MojuInfo.queryByBianhao",bianhao);
		System.out.println(mojuList+"kkkkkkkkkkkkkkkkkkkk");
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
		if (mojuList.size()>0) {
			return 1;
		} else {
			
		}
		return -1;
	}

	@Override
	public boolean updateMoju(MojuInfo moju) {
DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		System.out.println(moju.getLurushijian()+"555555555555566666666666");
		sqlSession.update("MojuInfo.update",moju);
		
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
	


