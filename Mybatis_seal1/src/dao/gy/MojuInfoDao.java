package dao.gy;

import java.sql.Timestamp;
import java.util.List;

import bean.gy.MojuInfo;





public interface MojuInfoDao {
	public boolean addMoju(MojuInfo moju);
	public List<MojuInfo> queryAll();
	public List<MojuInfo> queryByBianhao(String bianhao);
	public int checkByBianhao(String bianhao);
	public boolean updateMoju(MojuInfo moju);
	public boolean deleteMoju(String bianhao);
}
