package dao.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Area;

import dao.AreaDao;
import db.DBA;

public class AreaDaoImpl implements AreaDao {

	@Override
	public boolean addArea(Area area) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("Area.add",area);
		
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
	public List<Area> qurey() {
		DBA dba=new DBA();
		List <Area> areaList= new ArrayList<Area>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		areaList=sqlSession.selectList("Area.selectArea");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
		
		return areaList;
		
	}

	@Override
	public List qureyShuoming() {
		
		DBA dba=new DBA();
		List <Area> areaList= new ArrayList<Area>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		areaList=sqlSession.selectList("Area.selectAreaShuoming");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
		
		return areaList;
	}

	@Override
	public Area queryById( int id) {
		DBA dba=new DBA();
		Area area=new Area();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
	
		//通过sqlSession执行sql语句；
		area=sqlSession.selectOne("Area.selectAreaById",id);
	System.out.println(area);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
		
		return area;
	}

}
