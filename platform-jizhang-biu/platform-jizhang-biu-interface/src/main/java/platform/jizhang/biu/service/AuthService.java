package platform.jizhang.biu.service;

import java.util.Map;

public interface AuthService {

	String doLogin(Map<String, Object> reqMap) throws Exception;

	String getPermisonsById(Map<String, Object> reqMap) throws Exception;
	
}
