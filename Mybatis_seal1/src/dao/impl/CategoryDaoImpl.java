package dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Area;
import bean.Category;
import dao.CategoryDao;
import db.DBA;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean addCategory(Category category) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		sqlSession.insert("Category.add",category);
		
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
	public List<Category> query() {
		DBA dba=new DBA();
		List <Category> categoryList= new ArrayList<Category>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		Category category=new Category();
		//通过sqlSession执行sql语句；
		categoryList=sqlSession.selectList("Category.selectCategory",category);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
		
		return categoryList;
	}

	@Override
	public List qureyLeibie() {

		DBA dba=new DBA();
		List <Category> areaList= new ArrayList<Category>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		areaList=sqlSession.selectList("Category.selectCategory");
	
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
	public Category queryById(int id) {
		DBA dba=new DBA();
	 Category category= new Category();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		System.out.println("======================="+id);
		//通过sqlSession执行sql语句；
		category=sqlSession.selectOne("Category.selectCategoryById",id);
		System.out.println("======================="+category);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
		
		return category;
	}
	}


