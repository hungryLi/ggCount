package platform.jizhang.biu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import platform.jizhang.biu.service.AccountInfoService;
import platform.jizhang.biu.service.model.RoleVO;
import platform.jizhang.biu.service.persistence.mybatis.RoleVOMapper;
import platform.jizhang.biu.service.servlet.SpringPropertiesUtil;

@Component
@Service(version = "1.0.0")
public class AccountInfoServiceImpl implements AccountInfoService {

	private static final Logger logger = Logger.getLogger(AccountInfoServiceImpl.class);
	private static final String BASEINFO_URL = SpringPropertiesUtil.getProperty("platform-base-info-api-url");
	private static final String OPERATOR_URL = SpringPropertiesUtil.getProperty("platform-console-operator-api-url");

	@Autowired(required=true)
	private RoleVOMapper roleMapper;
	
	@Override
	public Map<String, Object> findAccountInfoById(Map<String, Object> reqMap) {

		RoleVO roleVO = roleMapper.selectByPrimaryKey(1);
		System.out.println(roleVO.getRoleCode());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", roleVO.getRoleCode());
		
		List<Map<String, Object>> resMap = roleMapper.selectTest(reqMap);
		System.out.println(" ====>   "+resMap.size());
		return map;
	}


	
	
	
	
	
}
