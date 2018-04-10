package platform.jizhang.biu.service.task;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.app.server.cache.ApiRedisKeyConstant;

import platform.common.utils.HttpUtil;
import platform.common.utils.MiscUtil;
import platform.jizhang.biu.service.servlet.SpringPropertiesUtil;

public class RechargeRefereeTask implements Runnable {
	private static final Logger logger = Logger.getLogger(RechargeRefereeTask.class);
	
	private static final String INFO_URL = SpringPropertiesUtil.getProperty("platform-api-information-api-url");
	
	private Map<String, Object> reqMap;
	
	public RechargeRefereeTask (Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}
	
	@Override
	public void run() {
		try {
			logger.info("==>会员首次充值,更新此会员的推荐人红利相关信息 ,reqMap" + reqMap);
			HttpUtil.doPost(INFO_URL + "/api/dividend/dividend_exchange", ApiRedisKeyConstant.API_SECRET_ACCESS_KEY_ID,MiscUtil.createRequestParm(reqMap));
		} catch (IOException e) {
			logger.error("--> 会员充值更新推荐人红利异常", e);
		}
	}
}
