package dao;

import java.util.List;

import bean.MieHuo;



public interface MieHuoDao {
	public boolean addMieHuo(MieHuo mHuo);  
	public List<MieHuo> queryAll(String jiancharen,String shebeibianhao);
	public int qureyByDate(String shebeibianhao);
		
	
}
