package action.user_auth;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import util.JsonDateValueProcessor;
import action.SuperAction;
import bean.Area;
import bean.user_auth.Permissions;
import dao.AreaDao;
import dao.impl.AreaDaoImpl;
import dao.uesr_auth.PermissionsDao;
import dao.uesr_auth.impl.PermissionsDaoImpl;

public class PermissionsAction extends SuperAction {

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
	
	

	public String add() {
		Permissions permissions=new Permissions();
		String url=request.getParameter("url");
		String name= request.getParameter("name");
		
		
		permissions.setText(name);
		permissions.setHref(url);;
		
		PermissionsDao pDao=new PermissionsDaoImpl();
		pDao.addPermissions(permissions);
		return "add_success";
	}
	
	public String query() {
		PermissionsDao pDao=new PermissionsDaoImpl();
		List<Permissions> result=pDao.qurey();

		
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Timestamp.class , new JsonDateValueProcessor());
		JSONArray js=JSONArray.fromObject(result,jsonConfig);
		JSONObject obj=new JSONObject();
		obj.put("data", js.toString());
		System.out.println(obj);
		
		this.object=obj;
		return "query_success";
	}
	
	
}
