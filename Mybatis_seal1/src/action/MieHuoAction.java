package action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;
import bean.MieHuo;
import bean.XiaoFang;
import dao.MieHuoDao;
import dao.XiaoFangDao;
import dao.impl.MieHuoDaoImpl;
import dao.impl.XiaoFangDaoImpl;

public class MieHuoAction extends SuperAction {

	private static final long serialVersionUID = 1L;

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
		 String beizhu= request.getParameter("beizhu");
         String jiancharen=request.getParameter("jiancharen");
         String bumen=request.getParameter("bumen");
         String shebeibianhao=request.getParameter("shebeibianhao");
         String shuliang=request.getParameter("shuliang");      
         Date date=new Date();      
         MieHuo mHuo=new MieHuo();
         mHuo.setJiancharen(jiancharen);
         mHuo.setShebeibianhao(shebeibianhao);
         mHuo.setShuliang(shuliang);
         mHuo.setBeizhu(beizhu);
         mHuo.setBumen(bumen);
         Timestamp date2 = new Timestamp(date.getTime());
         mHuo.setDate(date2);
         MieHuoDao mDao=new MieHuoDaoImpl();
         if (mHuo.getJiancharen() !=null && mHuo.getShebeibianhao() !=null) {
        	 mDao.addMieHuo(mHuo);
		}
         
		
	
	
			return "add_success";
		
	}
	
	
}
