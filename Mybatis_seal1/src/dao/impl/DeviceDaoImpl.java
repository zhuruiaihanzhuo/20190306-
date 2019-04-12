package dao.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Area;
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

	@Override
	public List<Device> query() {
		DBA dba=new DBA();
		List <Device> deviceList= new ArrayList<Device>();
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		Device device=new Device();
		//通过sqlSession执行sql语句；
		deviceList=sqlSession.selectList("Device.selectDevice",device);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (sqlSession !=null) {
				sqlSession.close();
			}
			
		}
	
	
		return deviceList;
		
	}

	@Override
	public boolean addDevice(Device device) {
		DBA dba=new DBA();
		
		SqlSession sqlSession=null;
		try {
		
		sqlSession=	dba.getSqlSession();
		System.out.println("9999999999999999999999999999999999999999999999999");
		//通过sqlSession执行sql语句；
		//System.out.println(area_id+"777777777777777777777777777777777777777777777777777777"+category_id);
		sqlSession.insert("Device.add",device);
		
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
