package dao.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Device;
import bean.MieHuo;
import dao.DeviceDao;
import db.DBA;

public class DeviceDaoImpl implements DeviceDao {

	@Override
	public Device selectByShebeibianhao(String shebeibianhao) {
		DBA dba=new DBA();
		Device device=new Device();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		
		//通过sqlSession执行sql语句；
		device=sqlSession.selectOne("Device.selectDeviceByshebeibianhao",shebeibianhao);
	
		
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}

	return device;
		
	}

}
