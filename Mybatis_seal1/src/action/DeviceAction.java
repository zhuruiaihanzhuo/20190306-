package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;
import bean.Area;
import bean.Category;
import bean.Device;
import dao.AreaDao;
import dao.CategoryDao;
import dao.DeviceDao;
import dao.impl.AreaDaoImpl;
import dao.impl.CategoryDaoImpl;
import dao.impl.DeviceDaoImpl;


public class DeviceAction extends SuperAction{

private  Object object;;
	
	
	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}


	
	private static final long serialVersionUID = 1L;

	public String  query() {
	
		DeviceDao deviceDao=new DeviceDaoImpl();
		List<Device> result=deviceDao.query();

		//System.out.println("ppppppppppppppppppppppppppppp");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object=obj;
		return "query_success";

	}
	
	

	public String addDevice() {
		Device device=new Device();
		String lururen=request.getParameter("lururen");
	
		String shebeibianhao= request.getParameter("shebeibianhao");
		
		String shuoming=request.getParameter("shuoming");
		String area_id=request.getParameter("quyu");
		String category_id=request.getParameter("leibie");
		
		String beizhu=request.getParameter("beizhu");
		CategoryDao cDao=new CategoryDaoImpl();
		Category category=cDao.queryById(Integer.parseInt(category_id));
		//System.out.println("======================="+category+"55555555555555555555");
		AreaDao aDao  =new AreaDaoImpl();
		Area area=   aDao.queryById(Integer.parseInt(area_id));
	
		Date date =new Date();
		Timestamp date2 = new Timestamp(date.getTime());
		device.setLururen(lururen);
		device.setArea(area);
		device.setShuoming(shuoming);
		device.setBeizhu(beizhu);
		device.setLurushijian(date2);
		device.setLeixing(category);
		device.setShebeibianhao(shebeibianhao);
		DeviceDao dDao=new DeviceDaoImpl();
	
		dDao.addDevice(device);
		
		return "add_success";
	}
	
}
