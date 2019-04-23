package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import net.sf.json.JSONObject;

import com.google.gson.Gson;

import dao.DeviceDao;
import dao.impl.DeviceDaoImpl;

public class DeviceServlet extends HttpServlet {
	/** 
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		//设置编码格式
		System.out.println("111111111111111111");
		response.setContentType("text/html;charset=utf-8");
	    response. setCharacterEncoding("UTF-8");
	    request. setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String shebeibianhao=request.getParameter("shebeibianhao");
		System.out.println(shebeibianhao);
		DeviceDao ddao=new DeviceDaoImpl();
		ddao.selectByShebeibianhao(shebeibianhao);
		
		Gson gson=new Gson();
	
	
		
        String aString=gson.toJson(ddao.selectByShebeibianhao(shebeibianhao));
    /*    JSONObject obj=new JSONObject();
		obj.put("data",ddao.selectByShebeibianhao(shebeibianhao));*/
		System.out.println(aString);

        out.print(aString);
        out.flush();
		out.close();
 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}
 
	public void init() throws ServletException {
	}
	
}
