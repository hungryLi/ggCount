
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import net.sf.json.JSONObject;

public class MyTest {

	public static void main(String[] args) throws Exception {
//		testUserAuth();
//	    testConvertUSD();
//		testAddCostInfo();
//		testEditCostInfo();
//		testQueryCostInfo();
		testDelCostInfo();
	}

	public static String doPost(String url, String value) throws Exception {
		HttpURLConnection urlconn = null;
		urlconn = (HttpURLConnection) new URL(url).openConnection();
		urlconn.getRequestProperties();
		urlconn.setRequestProperty("content-type", "application/json");
		urlconn.setRequestMethod("POST");
		urlconn.setConnectTimeout(10000);
		urlconn.setReadTimeout(10000);
		urlconn.setDoInput(true);
		urlconn.setDoOutput(true);
		urlconn.getOutputStream().write(value.getBytes());
		urlconn.getOutputStream().close();

		BufferedReader rd = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));

		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = rd.readLine();
		while (temp != null) {
			sb.append(temp);
			temp = rd.readLine();
		}
		rd.close();
		urlconn.disconnect();

		return sb.toString();
	}

	
	/**
	 * String paraData = reqJson.getString("para_data");
			String loginType = reqJson.getString("type");
			Map<String,String> reqMap = JSON.parseObject(paraData, new TypeReference<Map<String, String>>(){});
			String login_id = reqMap.get("login_id");
			String passwd = reqMap.get("passwd");
	 */
	private static void testUserAuth() {
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			String url = "http://127.0.0.1:8083/platform-console-auth-api/omsuser/login";
			json.put("role_id", "1");
			JSONObject data = new JSONObject();
			data.accumulate("login_id", "admin");
			data.accumulate("passwd", "d033e22ae348aeb5660fc2140aec35850c4da997");
			json.accumulate("para_data", data.toString());
			System.out.println(json.toString());
			String rs = HttpUtil.doPost(url, json.toString());
			System.err.println(" 返回结果" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testConvertUSD() throws Exception{
	    String url = "https://api.jijinhao.com/plus/convert.htm?from_tkc=USD&to_tkc=CNY&amount=1&"+System.currentTimeMillis ();
	    String  resStr = HttpUtil.doGet (url);
	    System.out.println (resStr);
	}
	
	private static void testQueryCostInfo() {
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			String url = "http://127.0.0.1:8081/platform-console-account-api/costinfo/query";
			json.put("role_id", "1");
			JSONObject data = new JSONObject();
			data.accumulate("page_size", "10");
			data.accumulate("page_num", "1");
			data.accumulate("collect_type", "1");
			data.accumulate("cost_name", "域名费");
			json.accumulate("para_data", data.toString());
			System.out.println(json.toString());
			String rs = HttpUtil.doPost(url, json.toString());
			System.err.println(" 返回结果" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void testAddCostInfo() {
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			String url = "http://127.0.0.1:8081/platform-console-account-api/costinfo/add";
			json.put("role_id", "1");
			JSONObject data = new JSONObject();
			data.accumulate("cost_name", "test");
			data.accumulate("cost_desc", "test");
			data.accumulate("cost_price", new BigDecimal("1"));
			data.accumulate("currency_id", "2");
			data.accumulate("currency_name", "USD");
			data.accumulate("discount_price",new BigDecimal("1"));
			JSONObject langName = new JSONObject();
			// {"zh_CN":"保证金费用","en_US":"保证金费用","default":"保证金费用"}
			langName.accumulate("zh_CN", "测试");
			langName.accumulate("en_US", "test");
			langName.accumulate("default", "测试");
			data.accumulate("lang_cost_name",langName);
			data.accumulate("cost_type", 1);
			data.accumulate("collect_type", 1);
			json.accumulate("para_data", data.toString());
			System.out.println(json.toString());
			String rs = HttpUtil.doPost(url, json.toString());
			System.err.println(" 返回结果" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void testEditCostInfo() {
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			String url = "http://127.0.0.1:8081/platform-console-account-api/costinfo/edit";
			json.put("role_id", "1");
			JSONObject data = new JSONObject();
			data.accumulate("cost_id", "8");
			data.accumulate("cost_name", "测试");
			data.accumulate("cost_desc", "test");
			data.accumulate("cost_price", new BigDecimal("2"));
			data.accumulate("currency_id", "2");
			data.accumulate("currency_name", "USD");
			data.accumulate("discount_price",new BigDecimal("0.8"));
			JSONObject langName = new JSONObject();
			// {"zh_CN":"保证金费用","en_US":"保证金费用","default":"保证金费用"}
			langName.accumulate("zh_CN", "测试");
			langName.accumulate("en_US", "test");
			langName.accumulate("default", "default");
			data.accumulate("lang_cost_name",langName);
			data.accumulate("cost_type", 1);
			data.accumulate("collect_type", 1);
			json.accumulate("para_data", data.toString());
			System.out.println(json.toString());
			String rs = HttpUtil.doPost(url, json.toString());
			System.err.println(" 返回结果" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void testDelCostInfo() {
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
			String url = "http://127.0.0.1:8081/platform-console-account-api/costinfo/del";
			json.put("role_id", "1");
			JSONObject data = new JSONObject();
			data.accumulate("cost_id", "8");
			data.accumulate("cost_name", "测试");
			data.accumulate("cost_desc", "test");
			data.accumulate("cost_price", new BigDecimal("2"));
			data.accumulate("currency_id", "2");
			data.accumulate("currency_name", "USD");
			data.accumulate("discount_price",new BigDecimal("0.8"));
			JSONObject langName = new JSONObject();
			// {"zh_CN":"保证金费用","en_US":"保证金费用","default":"保证金费用"}
			langName.accumulate("zh_CN", "测试");
			langName.accumulate("en_US", "test");
			langName.accumulate("default", "default");
			data.accumulate("lang_cost_name",langName);
			data.accumulate("cost_type", 1);
			data.accumulate("collect_type", 1);
			json.accumulate("para_data", data.toString());
			System.out.println(json.toString());
			String rs = HttpUtil.doPost(url, json.toString());
			System.err.println(" 返回结果" + rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
