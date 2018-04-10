package platform.jizhang.biu.service.task;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import platform.common.utils.HttpUtil;
import platform.common.utils.MiscUtil;
import platform.jizhang.biu.service.servlet.SpringPropertiesUtil;


public class StartOrStopOperTasK implements Runnable {
	
	private static final Logger log = Logger.getLogger(StartOrStopOperTasK.class);
	
	private static final String DOMAIN_URL = SpringPropertiesUtil.getProperty("platform-console-domain-info-url");
	
	private Map<String, Object> reqMap;
	
	public StartOrStopOperTasK (Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}
	
	@Override
	public void run() {
		try {
			log.info("==> 启动或停止运营商站点 ："+reqMap.toString());
			String result =	HttpUtil.doPost(DOMAIN_URL + "/domain/start_or_stop_domain", MiscUtil.createRequestParm(reqMap));
			log.info("==> 启动或停止运营商站点完成，结果："+result);
			
		} catch (IOException e) {
			log.error("--> 启动或停止运营商站点异常", e);
		}
	}
	
}
