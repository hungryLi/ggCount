package platform.jizhang.biu.api.controller;

import java.util.HashMap;
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
import platform.jizhang.biu.service.AccountInfoService;
import platform.jizhang.biu.service.ConsumeService;

@Controller
@RequestMapping("/consume")
public class ConsumeController {

	private static final Logger logger = Logger.getLogger(ConsumeController.class);

	@Reference(version = "1.0.0")
	private ConsumeService consumeService;

	
	/**
	 * 首页动态信息初始化
	 */
	@RequestMapping(value = "/list_index_activities")
	@ResponseBody
	public String listIndexActivities(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, String> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, String>>() {
			});
			if (StringUtils.isBlank(reqMap.get("user_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return consumeService.queryIndexActiviy(reqMap);
		} catch (Exception e) {
			logger.error("--> list_index_activities 首页喜欢活动信息列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	/**
	 * 添加消费记录
	 */
	@RequestMapping(value = "/add_consume")
	@ResponseBody
	public String addConsume(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, String> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, String>>() {
			});
			if (StringUtils.isBlank(reqMap.get("pay_user_id")) || StringUtils.isBlank(reqMap.get("price"))
					|| StringUtils.isBlank(reqMap.get("handler_type"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return consumeService.addOneConsume(reqMap);
		} catch (Exception e) {
			logger.error("--> 添加消费记录异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	/**
	 * 消费类型
	 * consume_id:有id根据id查询，无id查询所有类型
	 */
	@RequestMapping(value = "/select_consume_type")
	@ResponseBody
	public String queryConsumeType(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {
			});
			return consumeService.queryConsumeType(reqMap);
		} catch (Exception e) {
			logger.error("--> 查询消费类型信息异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}

	/**
	 * 根据userid查询所属的账户圈
	 */
	@RequestMapping(value = "/select_groups")
	@ResponseBody
	public String queryGroups(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, String> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, String>>() {
			});
			if (StringUtils.isBlank(reqMap.get("user_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return consumeService.queryGroups(reqMap);
		} catch (Exception e) {
			logger.error("--> 根据userid查询所属的账户圈信息异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	/**
	 * 查询账户圈的所有成员
	 */
	@RequestMapping(value = "/select_group_members")
	@ResponseBody
	public String queryGroupMembers(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, String> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, String>>() {
			});
			if (StringUtils.isBlank(reqMap.get("group_id"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return consumeService.queryGroupMembers(reqMap);
		} catch (Exception e) {
			logger.error("--> 查询账户圈的所有成员信息异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
}