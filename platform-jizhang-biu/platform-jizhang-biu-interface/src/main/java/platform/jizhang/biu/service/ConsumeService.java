package platform.jizhang.biu.service;

import java.util.Map;

public interface ConsumeService {

	String queryGroups(Map<String, String> reqMap) throws Exception;

	String queryGroupMembers(Map<String, String> reqMap) throws Exception;

	String addOneConsume(Map<String, String> reqMap) throws Exception;

	String queryConsumeType(Map<String, Object> reqMap) throws Exception;

	String queryIndexActiviy(Map<String, String> reqMap) throws Exception;

	String cancelLike(Map<String, String> reqMap) throws Exception;
	
}
