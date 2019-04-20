package dao.uesr_auth;

import java.util.List;

import bean.user_auth.Permissions;

public interface PermissionsDao {

	public boolean addPermissions(Permissions permissions);
	public List<Permissions> qurey();
}
