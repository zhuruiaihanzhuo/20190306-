package dao.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.XiaoFang;
import dao.XiaoFangDao;
import db.DBA;

public class XiaoFangDaoImpl implements XiaoFangDao {

	@Override
	public boolean addXiaoFang(XiaoFang xf) {
		
		return false;
	}

	@Override
	public List<XiaoFang> queryAll(String jiancharen, String shebeibianhao) {
	
		DBA dba=new DBA();
		List <XiaoFang> xiaoFangList= new ArrayList<XiaoFang>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		XiaoFang xf=new XiaoFang(jiancharen,shebeibianhao);
		//通过sqlSession执行sql语句；
		xiaoFangList=sqlSession.selectList("XiaoFang.queryAll",xf);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
		for (XiaoFang xiaoFang : xiaoFangList) {
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        
	         
			System.out.println(sdf.format(xiaoFang.getDate()));
		}
		
		return xiaoFangList;
	}

}
