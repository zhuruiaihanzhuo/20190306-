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
import dao.AreaDao;
import dao.CategoryDao;
import dao.impl.AreaDaoImpl;
import dao.impl.CategoryDaoImpl;

public class CategoryAction extends SuperAction{
private  Object object;
private  Object object2;
	
	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}
	
	
	public Object getObject2() {
		return object2;
	}


	public void setObject2(Object object2) {
		this.object2 = object2;
	}


	public String query() {
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> result=categoryDao.query();

		System.out.println("ppppppppppppppppppppppppppppp");
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object=obj;
		return "query_success";
	}
	
	
	public String queryLeibie() {
		CategoryDao cDao=new CategoryDaoImpl();
		List result=cDao.qureyLeibie();
	
		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object2=obj;
		return "queryLeibie_success";
	}
	
	
	
	public String addCategory() {
		Category category=new Category();
		String leibie=request.getParameter("leibie");
		String yuanyin= request.getParameter("yuanyin");
		String zerendanwei=request.getParameter("zerendanwei");
		String beizhu=request.getParameter("beizhu");
		Date date =new Date();
		Timestamp date2 = new Timestamp(date.getTime());
		category.setLeibie(leibie);
		category.setYuanyin(yuanyin);
		category.setZerendanwei(zerendanwei);
		category.setBeizhu(beizhu);
		category.setLurushijian(date2);
		CategoryDao cDao=new CategoryDaoImpl();
		cDao.addCategory(category);
		return "add_success";
	}
	
		
}
