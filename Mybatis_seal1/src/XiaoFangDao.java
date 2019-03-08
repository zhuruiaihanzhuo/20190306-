

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.XiaoFang;
import db.DBA;

public class XiaoFangDao {
		//根据查询条件查询消息列表
	public List<XiaoFang> queryXiaoFangList(XiaoFang xf){
		
		DBA dba=new DBA();
		List <XiaoFang> xiaoFangList= new ArrayList<XiaoFang>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		xiaoFangList=sqlSession.selectList("XiaoFang.queryXiaoFang",xf);
		
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
