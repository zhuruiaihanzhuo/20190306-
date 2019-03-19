package action;

import java.io.IOException;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;
import bean.Device;
import bean.MieHuo;

import dao.DeviceDao;
import dao.MieHuoDao;

import dao.impl.DeviceDaoImpl;
import dao.impl.MieHuoDaoImpl;


public class MieHuoAction extends SuperAction {

	private static final long serialVersionUID = 1L;

	private Object object;
	public Object getObject() {
		return object;
	}





	public void setObject(Object object) {
		this.object = object;
	}


	public String  qureyByDate() {
		
		MieHuoDao mh=new MieHuoDaoImpl();
		
		String shebeibianhao =request.getParameter("shebeibianhao");
		System.out.println(shebeibianhao+"----------------------");
		int r1 =mh.qureyByDate(shebeibianhao);
	/*	JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "success");
        jsonObject.put("data", js.toString());
		*/
		JSONObject obj=new JSONObject();
		obj.put("result", r1);
		//String result=obj.toString();
		this.object=obj;

		System.out.println(obj);
			return "checkByDate";
		
	}

	
	
	
	
	public String  qurey() {
	
		MieHuoDao mh=new MieHuoDaoImpl();
		String jiancharen  =request.getParameter("jiancharen");
		String shebeibianhao =request.getParameter("shebeibianhao");
		List<MieHuo> result =mh.queryAll(jiancharen, shebeibianhao);
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "success");
        jsonObject.put("data", js.toString());
		if (result !=null) {
			session.setAttribute("result", jsonObject);
			for (int i = 0; i < result.size(); i++) {
				
			}
			return "query_success";
		}
		else {
			return "query_error";
		}
	}
	
	public String  add() {
		String  shebeibianhao=request.getParameter("shebeibianhao");
		DeviceDao dDao=new DeviceDaoImpl();
		Device device= dDao.selectByShebeibianhao(shebeibianhao);
		System.out.println(request.getParameter("shebeibianhao"));
		//int i=Integer.parseInt((request.getParameter("shebeibianhao")));
	/*	System.out.println(request.getParameter("jiancharen"));
		System.out.println(request.getParameter("bumen"));
		System.out.println(i);
		System.out.println(request.getParameter("beizhu"));*/
			String beizhu= request.getParameter("beizhu");
         String jiancharen=request.getParameter("jiancharen");
         String bumen=request.getParameter("bumen");
        // String shebeibianhao=request.getParameter("shebeibianhao");
         String shuliang=request.getParameter("shuliang");      
         Date date=new Date();      
         MieHuo mHuo=new MieHuo();
         mHuo.setJiancharen(jiancharen);
       
        // mHuo.setShebeibianhao(shebeibianhao);
         mHuo.setShuliang(shuliang);
         mHuo.setBeizhu(beizhu);
         mHuo.setBumen(bumen);
         mHuo.setDevice_id(device);
         Timestamp date2 = new Timestamp(date.getTime());
         mHuo.setDate(date2);
         MieHuoDao mDao=new MieHuoDaoImpl();
         
        	 mDao.addMieHuo(mHuo);
			return "add_success";
		
	}
	
	
}
