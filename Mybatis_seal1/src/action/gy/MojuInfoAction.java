package action.gy;

import java.sql.Timestamp;
import java.util.Date;





import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;
import dao.gy.MojuInfoDao;
import dao.gy.impl.Moju_infoDaoImpl;


import bean.gy.MojuInfo;
import action.SuperAction;

public class MojuInfoAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object object;
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
	
	public String  add() {
		
		
	
		MojuInfo moju=new MojuInfo();
		String lururen=request.getParameter("lururen");


  
         String bianhao=request.getParameter("bianhao");      
         String shuoming=request.getParameter("shuoming");  
         String neirong=request.getParameter("content"); 
        // System.out.println(bianhao+shuoming+"        sdfsdf s索拉卡积分卡手机打开了手机打哈看不大恐怖"+neirong);
         Date date=new Date();     
         Timestamp date2 = new Timestamp(date.getTime());
         moju.setBianhao(bianhao);
         moju.setShuoming(shuoming);
         moju.setNeirong(neirong);
         moju.setLururen(lururen);
         moju.setLurushijian(date2);
         moju.setGenggaishijian(date2);
        
         MojuInfoDao mDao=new Moju_infoDaoImpl();
         mDao.addMoju(moju);
        	 
			return "add_success";
		
	}
	
	public String  queryByBianhao() {
		String bianhao=request.getParameter("bianhao");  
		MojuInfoDao mDao=new Moju_infoDaoImpl();
		
		List<MojuInfo> result =mDao.queryByBianhao(bianhao);
		//System.out.println("ppppppppppppppppppppppp"+result.get(0).getNeirong());
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		//System.out.println("lllllllllllllllllllllllllllllllllllllllllllll");
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		//System.out.println("222222222222222222222222222222222222");
		JSONObject obj=new JSONObject();
	//	System.out.println("33333333333333333333333333333");
    
        obj.put("data", js.toString());
        System.out.println(obj);
        this.object=obj;
		if (result !=null&&!"".equals(result)) {
			
		
		//	System.out.println("999999999999999999666666666666666");
			return "query_success";
		}
		else {
			return "query_error";
		}
	}
	
	public String  checkByBianhao() {
		String bianhao=request.getParameter("bianhao");  
		MojuInfoDao mDao=new Moju_infoDaoImpl();
		
		int result =mDao.checkByBianhao(bianhao);
		
		JSONObject obj=new JSONObject();
		obj.put("result", result);
		this.object2=obj;

		System.out.println(obj);
			return "checkByBianhao";
		
	}

	
	
	
	
	
}
