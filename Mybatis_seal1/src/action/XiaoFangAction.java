package action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;











import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import bean.Device;
import bean.MieHuo;
import bean.XiaoFang;
import dao.DeviceDao;
import dao.MieHuoDao;
import dao.XiaoFangDao;
import dao.impl.DeviceDaoImpl;
import dao.impl.MieHuoDaoImpl;
import dao.impl.XiaoFangDaoImpl;

public class XiaoFangAction extends SuperAction {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object object;
	public Object getObject() {
		return object;
	}





	public void setObject(Object object) {
		this.object = object;
	}


		public String  qurey() {
			
			XiaoFangDao xf=new XiaoFangDaoImpl();
		
			List<XiaoFang> result =xf.queryAll();
			JsonConfig jsonConfig = new JsonConfig();  //转换时间格式成为JSON传到前台
			jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
			JSONArray js=JSONArray.fromObject(result,jsonConfig);
			JSONObject jsonObject = new JSONObject();
	        jsonObject.put("msg", "success");
	        jsonObject.put("data", js.toString());
	        System.out.println(jsonObject);
			if (result !=null) {
				session.setAttribute("result", jsonObject);
			
				return "query_success";
			}
			else {
				return "query_error";
			}
		}
		
		
		public String  qureyByDate() {
			
			XiaoFangDao xf=new XiaoFangDaoImpl();
			
			String shebeibianhao =request.getParameter("shebeibianhao");
			System.out.println(shebeibianhao+"----------------------");
			int r1 =xf.qureyByDate(shebeibianhao);
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
		
		
		
		
		public String  add() {
			
			 String beizhu= request.getParameter("beizhu");
	         String jiancharen=request.getParameter("jiancharen");
	         String bumen=request.getParameter("bumen");
	         String shebeibianhao=request.getParameter("shebeibianhao");
	         String sqshuliang=request.getParameter("sqshuliang");  
	         String sdshuliang=request.getParameter("sdshuliang");
	         System.out.println(beizhu+jiancharen+bumen+shebeibianhao+sqshuliang+sdshuliang);
	         DeviceDao dDao=new DeviceDaoImpl();
	 		Device device= dDao.selectByShebeibianhao(shebeibianhao);
	         Date date=new Date();      
	         XiaoFang xFang=new XiaoFang();
	         xFang.setJiancharen(jiancharen);
	         xFang.setDevice_id(device.getId());
	         xFang.setSqshuliang(sqshuliang);
	         xFang.setSdshuliang(sdshuliang);
	         xFang.setBeizhu(beizhu);
	         xFang.setBumen(bumen);
	         Timestamp date2 = new Timestamp(date.getTime());
	         xFang.setDate(date2);
	         XiaoFangDao xDao=new XiaoFangDaoImpl();
	        /* if (xFang.getJiancharen() !=null && xFang.getShebeibianhao() !=null) {
	        	 xDao.addXiaoFang(xFang);
	        	 return "add_success";
			}*/
	         
	         xDao.addXiaoFang(xFang);
		
		
	         return "add_success";
		}
	
}
