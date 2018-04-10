package platform.jizhang.biu.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import platform.common.utils.HttpUtil;
import platform.common.utils.MiscUtil;

public class TestOne {

	public static void main(String[] args) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("user_id", 691);
		
		String url = "http://127.0.0.1:8081/platform-jizhang-biu-api/accountinfo/query_account_info";
		String res = HttpUtil.doPost(url , MiscUtil.createRequestParm(map));
		
		System.out.println(res);
		
	}

}
