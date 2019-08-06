package dao.gy;

import java.util.List;

import bean.gy.MojuInfo;





public interface MojuInfoDao {
	public boolean addMoju(MojuInfo moju);
	public List<MojuInfo> queryAll();
	public List<MojuInfo> queryByBianhao(String bianhao);
	public int checkByBianhao(String bianhao);
}
