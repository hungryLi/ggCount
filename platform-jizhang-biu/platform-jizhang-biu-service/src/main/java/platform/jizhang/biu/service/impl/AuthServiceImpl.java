package platform.jizhang.biu.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import net.sf.json.JSONObject;
import platform.common.utils.MiscUtil;
import platform.jizhang.biu.service.AuthService;
import platform.jizhang.biu.service.model.PermisionVO;
import platform.jizhang.biu.service.model.RoleVO;
import platform.jizhang.biu.service.persistence.mybatis.PermisionVOMapper;
import platform.jizhang.biu.service.persistence.mybatis.RolePermisionVOMapper;
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
	
	@Autowired(required = true)
	private RolePermisionVOMapper rolePermisionMapper;
	
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
	 * 登录用户权限列表（所有权限）
	 */
	@Override
	public String getLoginPermisons(Map<String, Object> reqMap) throws Exception {
		Integer user_id = Integer.valueOf(reqMap.get("user_id").toString());
		List<Map<String, Object>> permisions = permisionMapper.queryLoginPermisions(user_id);
		JSONObject retjson = new JSONObject();
		retjson.put("code", 0);
		retjson.put("msg", "success");
		retjson.put("res_data", permisions);
		return retjson.toString();
	}
	
	/**
	 * 登录用户角色列表
	 */
	@Override
	public String getLoginRoles(Map<String, Object> reqMap) throws Exception {
		Integer user_id = Integer.valueOf(reqMap.get("user_id").toString());
		List<Map<String, Object>> roles = roleMapper.queryLoginRoles(user_id);
		JSONObject retjson = new JSONObject();
		retjson.put("code", 0);
		retjson.put("msg", "success");
		retjson.put("res_data", roles);
		return retjson.toString();
	}
	
	/**
	 * 登录后查询所有的菜单信息
	 */
	@Override
	public String getPermisonsById(Map<String, Object> reqMap) throws Exception {
		Integer userId = Integer.valueOf(reqMap.get("user_id").toString());
//		Map<String, Object> roles = userRoleMapper.selectRolesByUserId(userId);
		Integer roleId = Integer.valueOf(reqMap.get("role_id").toString());
		List<Map<String, Object>> oneList = permisionMapper.selectPermisions(userId,roleId,1);
		List<Map<String, Object>> twoList = permisionMapper.selectPermisions(userId,roleId,2);
		JSONObject menuJson = new JSONObject();
		menuJson.put("code", 0);
		menuJson.put("msg", "success");
		menuJson.put("one_menu", oneList);
		menuJson.put("two_menu", twoList);
		return menuJson.toString();
	}

	@Override
	public String getRoles(Map<String, Object> reqMap) throws Exception {
		JSONObject json = new JSONObject();
		Integer pageNum  = Integer.valueOf(reqMap.get("page_num").toString());
		Integer pageSize  = Integer.valueOf(reqMap.get("page_size").toString());
		reqMap.put("page_num", (pageNum.intValue() - 1) * pageSize.intValue());
//		Integer total = roleMapper.countRole();
		List<Map<String, Object>> roles = roleMapper.queryRoles(reqMap);
		json.put("code", 1000);
		json.put("msg", "success");
//		json.put("count", total);
		json.put("res_data", roles);
		return json.toString();
	}


	@Override
	public String getPermisions(Map<String, Object> reqMap) throws Exception {
		JSONObject json = new JSONObject();
		Integer pageNum  = Integer.valueOf(reqMap.get("page_num").toString());
		Integer pageSize  = Integer.valueOf(reqMap.get("page_size").toString());
		reqMap.put("page_num", (pageNum.intValue() - 1) * pageSize.intValue());
		Integer total = permisionMapper.countPermisons(reqMap);
		List<Map<String, Object>> permisions = permisionMapper.queryRoles(reqMap);
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("count", total);
		json.put("res_data", permisions);
		return json.toString();
	}
	
	@Override
	public String updateRoles(Map<String, Object> reqMap) throws Exception {
		MiscUtil.convertMap(reqMap);
		JSONObject json = new JSONObject();
		RoleVO role = new RoleVO();
		role.setRoleName(reqMap.get("role_name").toString());
		role.setRoleCode(reqMap.get("role_code").toString());
		if(!MiscUtil.isEmpty(reqMap.get("role_desc"))) {
			role.setRoleDesc(reqMap.get("role_desc").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("role_id"))) {
			role.setId(Integer.valueOf(reqMap.get("role_id").toString()));
			roleMapper.updateByPrimaryKeySelective(role);
		}else {
			roleMapper.insertSelective(role);
		}
		json.put("code", 1000);
		json.put("msg", "success");
		return json.toString();
	}

	/**
	 * 父级别菜单列表
	 */
	@Override
	public String queryParentMenus(Map<String, Object> reqMap) throws Exception {
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("res_data", permisionMapper.selectOneMenus());
		return json.toString();
	}

	/**
	 * 添加权限
	 */
	@Override
	public String addPermission(Map<String, Object> reqMap) throws Exception {
		MiscUtil.convertMap(reqMap);
		PermisionVO pvo = new PermisionVO();
		if(!MiscUtil.isEmpty(reqMap.get("p_name"))) {
			pvo.setpName(reqMap.get("p_name").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("p_code"))) {
			pvo.setpCode(reqMap.get("p_code").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("menu_name"))) {
			pvo.setMenuName(reqMap.get("menu_name").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("parent_menu"))) {
			pvo.setParentMenu(Integer.valueOf(reqMap.get("parent_menu").toString()));
		}
		if(!MiscUtil.isEmpty(reqMap.get("menu_type"))) {
			pvo.setMenuType(Integer.valueOf(reqMap.get("menu_type").toString()));
		}
		if(!MiscUtil.isEmpty(reqMap.get("icon_type"))) {
			pvo.setIconType(Integer.valueOf(reqMap.get("icon_type").toString()));
		}
		if(!MiscUtil.isEmpty(reqMap.get("icon_address"))) {
			pvo.setIconAddress(reqMap.get("icon_address").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("menu_href"))) {
			pvo.setMenuHref(reqMap.get("menu_href").toString());
		}
		if(!MiscUtil.isEmpty(reqMap.get("menu_index"))) {
			pvo.setMenuIndex(Integer.valueOf(reqMap.get("menu_index").toString()));
		}
		if(!MiscUtil.isEmpty(reqMap.get("p_desc"))) {
			pvo.setpDesc(reqMap.get("p_desc").toString());
		}
		if(MiscUtil.isEmpty(reqMap.get("p_id"))) {
			permisionMapper.insertSelective(pvo);
		}else {
			pvo.setId(Integer.valueOf(reqMap.get("p_id").toString()));
			permisionMapper.updateByPrimaryKey(pvo);
		}
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		return json.toString();
	}

	@Override
	public String delPermission(Map<String, Object> reqMap) throws Exception {
		Integer pId = Integer.valueOf(reqMap.get("p_id").toString());
		permisionMapper.deleteByPrimaryKey(pId);
		rolePermisionMapper.deletePermision(pId);
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		return json.toString();
	}

	@Override
	public String queryOnePermission(Map<String, Object> reqMap) throws Exception {
		Integer pid = Integer.valueOf(reqMap.get("p_id").toString());
		PermisionVO permisionVO = permisionMapper.selectByPrimaryKey(pid);
		JSONObject json = new JSONObject();
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("res_data", permisionVO.toString());
		return json.toString();
	}

	/**
	 * 已有权限
	 */
	@Override
	public String queryRoleHasPermission(Map<String, Object> reqMap) throws Exception {
		MiscUtil.convertMap(reqMap);
		JSONObject json = new JSONObject();
		Integer pageNum  = Integer.valueOf(reqMap.get("page_num").toString());
		Integer pageSize  = Integer.valueOf(reqMap.get("page_size").toString());
		reqMap.put("page_num", (pageNum.intValue() - 1) * pageSize.intValue());
		Integer total = rolePermisionMapper.countHasPermisons(reqMap);
		List<Map<String, Object>> permisions = rolePermisionMapper.queryHasPermison(reqMap);
		json.put("code", 1000);
		json.put("msg", "success");
		json.put("count", total);
		json.put("res_data", permisions);
		return json.toString();
	}




	
	

}
