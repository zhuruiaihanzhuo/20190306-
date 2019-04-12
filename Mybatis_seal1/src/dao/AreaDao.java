package dao;

import java.util.List;

import bean.Area;

public interface AreaDao {
	public boolean addArea(Area area);
	public List<Area> qurey();
	public List qureyShuoming();
	public Area queryById(int id);
}
