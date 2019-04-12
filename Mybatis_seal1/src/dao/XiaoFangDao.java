package dao;

import java.util.List;

import bean.XiaoFang;

public interface XiaoFangDao {
	public boolean addXiaoFang(XiaoFang xf);  
	public List<XiaoFang> queryAll();
	public int qureyByDate(String shebeibianhao);
	
}
