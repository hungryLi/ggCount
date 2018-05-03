package platform.jizhang.biu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import net.sf.json.JSONObject;
import platform.common.utils.MiscUtil;
import platform.jizhang.biu.service.AuthService;
import platform.jizhang.biu.service.persistence.mybatis.PermisionVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.RoleVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.UserRoleVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.UserVOMapper;

@Component
@Service(version = "1.0.0")
public class AuthServiceImpl implements AuthService {

	
	@Autowired(required=true)
	private UserVOMapper userMapper;
	
	@Autowired(required = true)
	private UserRoleVOMapper userRoleMapper;
	
	@Autowired(required = true)
	private RoleVOMapper roleMapper;
	
	@Autowired(required = true)
	private PermisionVOMapper permisionMapper;
	
	@Override
	public String doLogin(Map<String, Object> reqMap) throws Exception {
		MiscUtil.convertMap(reqMap);
		
		JSONObject retJson = new JSONObject();
		
		List<Map<String, Object>> user = userMapper.selectUserInfo(reqMap);
		if(user != null && !user.isEmpty() && user.size() == 1) {
			retJson.put("code", 0);
			retJson.put("msg", "success");
			retJson.put("res_data", user.get(0));
			return retJson.toString();
		}
		Integer count = userMapper.selectUserByName(reqMap.get("login_id").toString());
		if(count == null || count.intValue() == 0) {
			retJson.put("code", 3);
			retJson.put("msg", "用户名不存在");
		}else {
			retJson.put("code", 4);
			retJson.put("msg", "用户名存在 但密码错误");
		}
		return retJson.toString();
	}

	/**
	 * 登录后查询所有的菜单信息
	 */
	@Override
	public String getPermisonsById(Map<String, Object> reqMap) throws Exception {
		Integer userId = Integer.valueOf(reqMap.get("user_id").toString());
		Map<String, Object> roles = userRoleMapper.selectRolesByUserId(userId);
		Integer roleId = Integer.valueOf(roles.get("role_id").toString());
		List<Map<String, Object>> menuList = permisionMapper.selectPermisions(roleId);
		
		return null;
	}

	
	

}
