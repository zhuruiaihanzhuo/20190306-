package dao;

import java.util.List;



import bean.Device;

public interface DeviceDao {
		public Device selectByShebeibianhao(String shebeibianhao);
			
		public boolean addDevice(Device device);
		public List<Device> query();

}
