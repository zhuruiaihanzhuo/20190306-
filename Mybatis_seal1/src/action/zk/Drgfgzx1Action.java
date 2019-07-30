package action.zk;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;



import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import net.sf.json.JsonConfig;
import bean.Device;
import bean.zk.Drgfgzx1;
import dao.DeviceDao;
import dao.impl.DeviceDaoImpl;
import dao.zk.Drgfgzx1Dao;
import dao.zk.impl.Drgfgzx1DaoImpl;
import action.SuperAction;

public class Drgfgzx1Action extends SuperAction{

	/**
	 * 
	 */
	
	private Object object;
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	private static final long serialVersionUID = 1L;
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
         String lururen=request.getParameter("lururen");
         String bumen=request.getParameter("bumen");
        // String shebeibianhao=request.getParameter("shebeibianhao");
         String one=request.getParameter("one");      
         String two=request.getParameter("two");  
         String three=request.getParameter("three"); 
         String four=request.getParameter("four");      
         String five=request.getParameter("five");  
         String six=request.getParameter("six");  
         String seven=request.getParameter("seven");      
         String eight=request.getParameter("eight");  
         String nine=request.getParameter("nine");  
         Date date=new Date();     
         Timestamp date2 = new Timestamp(date.getTime());
        Drgfgzx1 drgfgzx1=new Drgfgzx1();
        drgfgzx1.setLururen(lururen);
        drgfgzx1.setLurushijian(date2);
        drgfgzx1.setBumen(bumen);
        drgfgzx1.setBeizhu(beizhu);
        drgfgzx1.setOne(one);
        drgfgzx1.setTwo(two);
        drgfgzx1.setThree(three);
        drgfgzx1.setFour(four);
        drgfgzx1.setFive(five);
        drgfgzx1.setSix(six);
        drgfgzx1.setSeven(seven);
        drgfgzx1.setEight(eight);
        drgfgzx1.setNine(nine);
        drgfgzx1.setDevice_id(device);
        // mHuo.setShebeibianhao(shebeibianhao);
        
        Drgfgzx1Dao drDao=new Drgfgzx1DaoImpl();
         drDao.add(drgfgzx1);
        	 
			return "add_success";
		
	}
	
	
	public String  query() {
		
		Drgfgzx1Dao dDao=new Drgfgzx1DaoImpl();
		
		List<Drgfgzx1> result =dDao.queryAll();
		System.out.println(result);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();

    
        obj.put("data", js.toString());
        System.out.println(obj);
        this.object=obj;
		if (result !=null) {
			
		
			System.out.println("999999999999999999666666666666666");
			return "query_success";
		}
		else {
			return "query_error";
		}
	}
	
}
