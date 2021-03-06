package platform.jizhang.biu.service;

import java.util.Map;

public interface AuthService {

	String doLogin(Map<String, Object> reqMap) throws Exception;

	String getPermisonsById(Map<String, Object> reqMap) throws Exception;

	String getRoles(Map<String, Object> reqMap) throws Exception;

	String updateRoles(Map<String, Object> reqMap) throws Exception;

	String getLoginPermisons(Map<String, Object> reqMap) throws Exception;

	String getLoginRoles(Map<String, Object> reqMap) throws Exception;

	String getPermisions(Map<String, Object> reqMap) throws Exception;

	String queryParentMenus(Map<String, Object> reqMap) throws Exception;

	String addPermission(Map<String, Object> reqMap) throws Exception;

	String delPermission(Map<String, Object> reqMap) throws Exception;

	String queryOnePermission(Map<String, Object> reqMap) throws Exception;

	String queryRoleHasPermission(Map<String, Object> reqMap) throws Exception;

	String roleRelPermissions(Map<String, Object> reqMap) throws Exception;
	
}
