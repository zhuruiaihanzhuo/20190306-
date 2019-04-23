package action.zk;

import java.sql.Timestamp;
import java.util.Date;

import bean.Device;
import bean.MieHuo;
import bean.zk.Drgfgzx1;
import dao.DeviceDao;
import dao.MieHuoDao;
import dao.impl.DeviceDaoImpl;
import dao.impl.MieHuoDaoImpl;
import dao.zk.Drgfgzx1Dao;
import dao.zk.impl.Drgfgzx1DaoImpl;
import action.SuperAction;

public class Drgfgzx1Action extends SuperAction{

	private Object object;
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
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
	
	
}
