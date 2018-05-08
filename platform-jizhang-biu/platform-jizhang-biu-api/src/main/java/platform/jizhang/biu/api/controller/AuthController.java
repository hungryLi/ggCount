package platform.jizhang.biu.api.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import platform.common.utils.MiscUtil;
import platform.jizhang.biu.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	private static final Logger logger = Logger.getLogger(AuthController.class);
	
	@Reference(version = "1.0.0")
	private AuthService authService;
	
	/**
	 * 用户登录接口
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public String queryAccountInfo(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {
			});
			if (MiscUtil.isEmpty(reqMap.get("login_id")) || MiscUtil.isEmpty(reqMap.get("passwd"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.doLogin(reqMap);
		} catch (Exception e) {
			logger.error("--> 用户登录异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	//  get_permisions
	@RequestMapping(value = "/get_menu_permisions")
	@ResponseBody
	public String queryMenuPermisons(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {});
			if(MiscUtil.isEmpty(reqMap.get("user_id")) || MiscUtil.isEmpty(reqMap.get("role_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "[user_id,role_id]必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.getPermisonsById(reqMap);
		} catch (Exception e) {
			logger.error("--> 用户登录获取菜单列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	// 获取登录用户权限列表
	@RequestMapping(value = "/login_permisions")
	@ResponseBody
	public String queryLoginPermisons(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {});
			if(MiscUtil.isEmpty(reqMap.get("user_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "[user_id]必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.getLoginPermisons(reqMap);
		} catch (Exception e) {
			logger.error("--> 用户登录获取权限列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	// 获取登录用户角色列表
	@RequestMapping(value = "/login_roles")
	@ResponseBody
	public String queryLoginRoles(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {});
			if(MiscUtil.isEmpty(reqMap.get("user_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "[user_id]必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.getLoginRoles(reqMap);
		} catch (Exception e) {
			logger.error("--> 获取登录用户角色列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	@RequestMapping(value = "/role_list")
	@ResponseBody
	public String queryRoles(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {});
			if(MiscUtil.isEmpty(reqMap.get("page_num")) || MiscUtil.isEmpty(reqMap.get("page_size"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "[page_num，page_size]必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.getRoles(reqMap);
		} catch (Exception e) {
			logger.error("--> 查询角色信息列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "查询角色信息列表异常");
			return jsonObject.toJSONString();
		}
	}
	
	@RequestMapping(value = "/role_update")
	@ResponseBody
	public String updateRoles(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {});
			if(MiscUtil.isEmpty(reqMap.get("role_name")) || MiscUtil.isEmpty(reqMap.get("role_code"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "[role_name，role_code]必填参数为空");
				return jsonObject.toJSONString();
			}
			return authService.updateRoles(reqMap);
		} catch (Exception e) {
			logger.error("-->更新异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "更新角色异常异常");
			return jsonObject.toJSONString();
		}
	}
	
}
