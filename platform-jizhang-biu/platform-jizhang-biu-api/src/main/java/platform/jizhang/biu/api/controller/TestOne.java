package platform.jizhang.biu.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import platform.common.utils.HttpUtil;
import platform.common.utils.MiscUtil;

public class TestOne {

	public static void main(String[] args) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("login_id", "admin");
		map.put("passwd", "admin");
		map.put("user_id", 1);
		
		String url = "http://127.0.0.1:8081/platform-jizhang-biu-api/accountinfo/query_account_info";
		String url1 = "http://127.0.0.1:8081/platform-jizhang-biu-api/auth/login";
		String url3 = "http://127.0.0.1:8081/platform-jizhang-biu-api/auth/get_permisions";
		String res = HttpUtil.doPost(url3 , MiscUtil.createRequestParm(map));
		
		System.out.println(res);
		
		
	}

}
