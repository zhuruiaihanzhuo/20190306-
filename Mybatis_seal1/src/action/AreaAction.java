package action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import dao.AreaDao;
import dao.impl.AreaDaoImpl;
import bean.Area;

public class AreaAction extends SuperAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Object object;;
	private Object object2;
	
	public Object getObject2() {
		return object2;
	}


	public void setObject2(Object object2) {
		this.object2 = object2;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	public String query() {
		AreaDao areaDao=new AreaDaoImpl();
		List<Area> result=areaDao.qurey();

		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object=obj;
		return "query_success";
	}
	
	public String queryShuoming() {
		AreaDao areaDao=new AreaDaoImpl();
		List result=areaDao.qureyShuoming();
	
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object2=obj;
		return "queryShuoming_success";
	}
	
	
	public String addArea() {
		Area area=new Area();
		String lururen=request.getParameter("lururen");
		String quyudaima= request.getParameter("quyudaima");
		String zerenbumen=request.getParameter("zerenbumen");
		String shuoming=request.getParameter("shuoming");
		String beizhu=request.getParameter("beizhu");
		Date date =new Date();
		Timestamp date2 = new Timestamp(date.getTime());
		area.setLururen(lururen);
		area.setQuyudaima(quyudaima);
		area.setShuoming(shuoming);
		area.setBeizhu(beizhu);
		area.setLurushijian(date2);
		area.setZerenbumen(zerenbumen);
		AreaDao aDao=new AreaDaoImpl();
		aDao.addArea(area);
		return "add_success";
	}
	
	
		
}
