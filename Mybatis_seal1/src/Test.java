import java.io.IOException;
import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.DBA;
import bean.Area;
import bean.Device;
import bean.MieHuo;
import bean.XiaoFang;


public class Test {
public static void main(String[] args) {
	DBA dba=new DBA();
	
	SqlSession sqlSession=null;
	List <Device> devicesList= new ArrayList<Device>();
	
	try {
		sqlSession=	dba.getSqlSession();
		//通过sqlSession执行sql语句；
		//通过sqlSession执行sql语句；
		devicesList=sqlSession.selectList("Device.selectDevice",2);
		for (Device device : devicesList) {
			System.out.println(device.getArea().getShuoming());
		
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
finally{

}

}
}
