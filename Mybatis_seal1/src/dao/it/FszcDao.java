package dao.it;

import java.util.List;

import bean.it.Fszc;

public interface FszcDao {

	
	public boolean addFszc(Fszc fszc);
	public List<Fszc> query();
	public List<Fszc> queryByDepartment(String depatment);
	
}
