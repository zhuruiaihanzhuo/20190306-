package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;





import util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import bean.XiaoFang;
import dao.XiaoFangDao;
import dao.impl.XiaoFangDaoImpl;

public class XiaoFangAction extends SuperAction {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public String  qurey() {
			System.out.println("---------------------------------------");
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
				for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i));
				}
				return "query_success";
			}
			else {
				return "query_error";
			}
		}
		public String  add() {
			 String tc= request.getParameter("tc");
	         String jiancharen=request.getParameter("name");
	         String bumen=request.getParameter("bumen");
	         String bianma=request.getParameter("number");
	         String shuliang=request.getParameter("shuliang");
	         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	         Date date=new Date();
	         String date2=sdf.format(date);
	         XiaoFang xf=new XiaoFang();
	         xf.setBeizhu(tc);
	         xf.setBumen(bumen);
	         xf.setDate(date);
		//	XiaoFangDao xf=new XiaoFangDaoImpl();
			
		
		
				return "query_error";
			
		}
	
}
