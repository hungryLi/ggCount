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

/**
 * 账户充值
 * 
 * @author Liujf
 *
 */
@Controller
@RequestMapping("/accountinfo")
public class AccountInfoController {

	private static final Logger logger = Logger.getLogger(AccountInfoController.class);

	@Reference(version = "1.0.0")
	private AccountInfoService accountInfoService;


	/**
	 * 查询用户账户信息
	 */
	@RequestMapping(value = "/query_account_info")
	@ResponseBody
	public String queryAccountInfo(HttpServletResponse resp, HttpServletRequest req) {
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
			Map<String, Object> parMap = new HashMap<String, Object>();
			if (!StringUtils.isBlank(reqMap.get("user_id"))) {
				parMap.put("user_id", Integer.valueOf(reqMap.get("user_id")));
			}
			if (!StringUtils.isBlank(reqMap.get("account_id"))) {
				parMap.put("account_id", Integer.valueOf(reqMap.get("account_id")));
			}
			Map<String, Object> data = accountInfoService.findAccountInfoById(parMap);
			jsonObject.put("code", 0);
			jsonObject.put("msg", "查询成功");
			jsonObject.put("res_data", data);
			return jsonObject.toJSONString();
		} catch (Exception e) {
			logger.error("--> 查询用户账户信息异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}

}