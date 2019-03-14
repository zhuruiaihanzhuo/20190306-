package action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;








import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import bean.MieHuo;
import bean.XiaoFang;
import dao.MieHuoDao;
import dao.XiaoFangDao;
import dao.impl.MieHuoDaoImpl;
import dao.impl.XiaoFangDaoImpl;

public class XiaoFangAction extends SuperAction {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public String  qurey() {
			
			XiaoFangDao xf=new XiaoFangDaoImpl();
			String jiancharen  =request.getParameter("jiancharen");
			String shebeibianhao =request.getParameter("shebeibianhao");
			List<XiaoFang> result =xf.queryAll(jiancharen, shebeibianhao);
			JsonConfig jsonConfig = new JsonConfig();  //转换时间格式成为JSON传到前台
			jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
			JSONArray js=JSONArray.fromObject(result,jsonConfig);
			JSONObject jsonObject = new JSONObject();
	        jsonObject.put("msg", "success");
	        jsonObject.put("data", js.toString());
			if (result !=null) {
				session.setAttribute("result", jsonObject);
			
				return "query_success";
			}
			else {
				return "query_error";
			}
		}
		public String  add() {
			
			 String beizhu= request.getParameter("beizhu");
	         String jiancharen=request.getParameter("jiancharen");
	         String bumen=request.getParameter("bumen");
	         String shebeibianhao=request.getParameter("shebeibianhao");
	         String sqshuliang=request.getParameter("sqshuliang");  
	         String sdshuliang=request.getParameter("sdshuliang");
	         System.out.println(beizhu+jiancharen+bumen+shebeibianhao+sqshuliang+sdshuliang);
	         Date date=new Date();      
	         XiaoFang xFang=new XiaoFang();
	         xFang.setJiancharen(jiancharen);
	         xFang.setShebeibianhao(shebeibianhao);
	         xFang.setSqshuliang(sqshuliang);
	         xFang.setSdshuliang(sdshuliang);
	         xFang.setBeizhu(beizhu);
	         xFang.setBumen(bumen);
	         Timestamp date2 = new Timestamp(date.getTime());
	         xFang.setDate(date2);
	         XiaoFangDao xDao=new XiaoFangDaoImpl();
	         if (xFang.getJiancharen() !=null && xFang.getShebeibianhao() !=null) {
	        	 xDao.addXiaoFang(xFang);
			}
	         
			
		
		
				return "add_success";
		}
	
}
