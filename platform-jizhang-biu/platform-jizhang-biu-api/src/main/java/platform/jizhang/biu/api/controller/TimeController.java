package platform.jizhang.biu.api.controller;

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
import platform.jizhang.biu.service.ConsumeService;
import platform.jizhang.biu.service.TimeService;

@Controller
@RequestMapping("/time")
public class TimeController {

	private static final Logger logger = Logger.getLogger(TimeController.class);

	@Reference(version = "1.0.0")
	private TimeService timeService;

	
	/**
	 * 点滴页面生活记录
	 */
	@RequestMapping(value = "/list_times")
	@ResponseBody
	public String listTimes(HttpServletResponse resp, HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		try {
			JSONObject reqJson = MiscUtil.getRequestBody(req.getInputStream());
			String paraData = reqJson.getString("para_data");
			Map<String, Object> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, Object>>() {
			});
			if (MiscUtil.isEmpty(reqMap.get("page_num")) || MiscUtil.isEmpty(reqMap.get("page_size"))) {
				jsonObject.put("code", 10001);
				jsonObject.put("msg", "必填参数为空");
				return jsonObject.toJSONString();
			}
			return timeService.queryTimeList(reqMap);
		} catch (Exception e) {
			logger.error("--> list_index_activities 首页喜欢活动信息列表异常");
			jsonObject.put("code", 2);
			jsonObject.put("msg", "异常");
			return jsonObject.toJSONString();
		}
	}
	
	
}