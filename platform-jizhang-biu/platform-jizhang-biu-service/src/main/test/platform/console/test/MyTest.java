package platform.console.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONArray;

import net.sf.json.JSONObject;

public class MyTest {

	// 1832405，1832406，1832407,1832408，1832409,1839990，1839991，1839992,1874270
	private static final String postString = "{ \"method\": \"account.login\",\"params\": {\"account\": \"aKvpxU1LekEffCbEEsry+NQtMjcZhjjzwS/5I2xMqBh67oWh+bLq1IM8g\",\"password\": \"aKvpxU1LekEffCeFTtL/lN1obj8wx2W/0Qah5/FBoRUb6mWp4b8usc5IM+0d0hB/A8XFkQ/XjJh/wHg\"}} ";
	private static final String shPostString = "{ \"method\": \"account.login\",\"params\": {\"account\": \"aKvpxU1LekEffCbEEsry+NQtMjcZhjjzwS/5I2xMqBh67oWh+bLq1IM8g\",\"password\": \"aKvpxU1LekEffCeUH4Ou4NwlM3M0zj2D2G6pL1hQnQET8+Whs\"}} ";
	// private static final String URL = "http://localhost:8080/aam/rpc";
	private static final String URL = "http://221.181.41.29:8091/aam/rpc";

	public static void main(String[] args) {
         

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

//	private static void testPosterRequest() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			String url = "http://120.25.56.90:9080/app-server-ifs/v1/poster/reg/youmi/android";
//			json.put("imei", "f0ba7eff3a6a44269c105f8d2bbbb1ca");
//			json.put("callback_url", "www.sina.com");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw_poster_key";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			System.out.println("req: " + req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private static void testGoldDetail() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://120.25.56.90:9092/app-server-api/user/get_user_list";
//			// String url =
//			// "http://120.25.56.90:9091/app-server-ifs/v1/user/get_user_list";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/get_client_version";
//			String url = "http://api.1758app.com/v1/task/gold_detail";
//			// http://api.1758app.com/v1/area/get_nation_list
//			// String url = "http://api.1758app.com/v1/account/login";
//			JSONArray jarr = new JSONArray();
//			jarr.add("2");
//			json.put("user_id", "f0ba7eff3a6a44269c105f8d2bbbb1ca");
//			json.put("size", 5);
//			json.put("type", 1);
//			// json.put ("login_id", "15813880586");
//			// json.put ("passwd", "96E79218965EB72C92A549DD5A330112");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			System.out.println("req: " + req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testVersionInfo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://120.25.56.90:9092/app-server-api/user/get_user_list";
//			// String url =
//			// "http://120.25.56.90:9091/app-server-ifs/v1/user/get_user_list";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/get_client_version";
//			String url = "http://api.1758app.com/v1/get_client_version";
//			// http://api.1758app.com/v1/area/get_nation_list
//			// String url = "http://api.1758app.com/v1/account/login";
//			JSONArray jarr = new JSONArray();
//			jarr.add("2");
//			json.put("user_ids", jarr.toString());
//			// json.put ("login_id", "15813880586");
//			// json.put ("passwd", "96E79218965EB72C92A549DD5A330112");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			System.out.println("req: " + req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetUserInfo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://120.25.56.90:9092/app-server-api/user/get_user_list";
//			String url = "http://120.25.56.90:9091/app-server-ifs/v1/user/get_user_list";
//			// String url =
//			// "http://localhost:8091/app-server-ifs/v1/user/get_user_list";
//			// http://api.1758app.com/v1/area/get_nation_list
//			// String url = "http://api.1758app.com/v1/account/login";
//			JSONArray jarr = new JSONArray();
//			jarr.add("2");
//			json.put("user_ids", jarr.toString());
//			// json.put ("login_id", "15813880586");
//			// json.put ("passwd", "96E79218965EB72C92A549DD5A330112");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "djim";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			System.out.println("req: " + req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testLoign() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/v1/account/login";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/account/login";
//			// String url = "http://120.24.53.26:9080/v1/account/login";
//			String url = "http://120.25.56.90:7000/v1/account/login";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-api/account/login";
//			// String url =
//			// "http://120.25.104.68:8081/app-server-api/account/login";
//			// http://api.1758app.com/v1/area/get_nation_list
//			// String url = "http://api.1758app.com/v1/account/login";
//			// json.put ("login_id", "15813880586");
//			// json.put ("passwd", "96E79218965EB72C92A549DD5A330112");
//			json.put("login_id", "13246671101");
//			json.put("passwd", MD5Util.getMD5("123456"));
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			String rs = HttpUtil.doPost(url, req.toString());
//
//			// if(!rs.contains("res_data"))
//			System.out.println(" 返回结果" + rs);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testAttention() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/v1/account/login";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/account/login";
//			// String url = "http://120.25.56.90:7000/v1/account/login";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-api/account/login";
//			String url = "http://120.25.56.90:9080/app-server-ifs/v1/attention/add";
//			// http://api.1758app.com/v1/area/get_nation_list
//			// String url = "http://api.1758app.com/v1/account/login";
//			json.put("user_id", "f9a0bcde9bce482496a95104363137cd");
//			json.put("target_id", "e9951eaf36204388952f4a7a34daa7a3");
//			String jstr = json.toString();
//			// gcw +token
//			jstr = jstr + time + time + "gcw" + "0894afff96ba47c6be61f942f5cef821";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			String rs = HttpUtil.doPost(url, req.toString());
//
//			// if(!rs.contains("res_data"))
//			System.out.println(" 返回结果" + rs);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testCodeGet() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://120.25.56.90:9080/app-server-ifs/v1/code/get";
//			json.put("login_id", "15813880586");
//			json.put("type", "1");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testEditUserInfo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://120.25.56.90:9080/app-server-ifs/user/edit_info";
//			json.put("user_id", "cc7c180bd5e5479094647bcf13c4172f");
//			json.put("name", "龙cc7c180bd5e5479094647bcf13c4172f");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw" + "ba07723bddf84ba998971ce4d21a1e9f";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", 1);
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testLogout() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"msg":"登录成功！","code":0,"res_data":{"birthday":"","m_user_id":"600140","user_id":"9ffca1e6186d4ec69f4fce4dbaaacdcb","m_pwd":"108e35fe","phone_number":"13246671112","token":"3a64a4dbe28a47b6ae70fcfb11e3df61"}}
//			String url = "http://120.25.56.90:9080/app-server-ifs/account/logout";
//			json.put("user_id", "9ffca1e6186d4ec69f4fce4dbaaacdcb");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw" + "3a64a4dbe28a47b6ae70fcfb11e3df61";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testPhone() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://api.1758app.com/v1/user/check_login_id";
//			json.put("login_id", "1380013800013800138000");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String postStr = "{ \"method\": \"account.logout\",\"params\": {\"tokenId\": \"MTY1NDU5MDAwNA==\"}} ";
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testPhoneCodeGet() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://api.1758app.com/v1/code/get";
//			json.put("login_id", "15813880586");
//			json.put("type", "1");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String postStr = "{ \"method\": \"account.logout\",\"params\": {\"tokenId\": \"MTY1NDU5MDAwNA==\"}} ";
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGroupAdd() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://120.25.56.90:9081/gcw/group/add";
//			json.put("user_id", "ad2467d0bab24cf88fae9fc9ed1257bf");
//			json.put("group_name", "ad2467d0bab24cf88fae9fc9ed1257bf");
//			json.put("group_desc", "一米阳光");
//			json.put("group_pic", "http://7xqyre.com2.z0.glb.qiniucdn.com/images/C54C57003ECA045AD0F5D2C0808E1DF3.png");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String postStr = "{ \"method\": \"account.logout\",\"params\": {\"tokenId\": \"MTY1NDU5MDAwNA==\"}} ";
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGroupDetail() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			String url = "http://120.25.56.90:9081/gcw/group/detail";
//			json.put("group_id", "7d799a6d40a775e31c94df0b6f876748");
//			json.put("group_name", "ad2467d0bab24cf88fae9fc9ed1257bf");
//			json.put("group_desc", "一米阳光");
//			json.put("group_pic", "http://7xqyre.com2.z0.glb.qiniucdn.com/images/C54C57003ECA045AD0F5D2C0808E1DF3.png");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String postStr = "{ \"method\": \"account.logout\",\"params\": {\"tokenId\": \"MTY1NDU5MDAwNA==\"}} ";
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testSearchVideo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//			/**
//			 * 1 start Y int 20 查询开始记录下标 2 end Y int 20 查询结束记录下标 3 type Y string
//			 * 1 搜索类型 1：热门推荐由后台人工推荐 2：最热排行按照点击量 3：最新视频按照时间 4 item_id N string 32
//			 * 视频所属分类ID
//			 */
//
//			String url = "http://120.25.56.90:9080/app-server-ifs/search/video";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/video";
//			// String url =
//			// "http://localhost:8080/app-server-search-api/search/video";
//			// String url = "http://api.1758app.com/v1/search/video";
//			json.put("start", 0);
//			json.put("end", 100);
//			json.put("key_word", "咻一咻");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			System.out.println("req:" + req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.out.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testSearchuser() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			String url = "http://localhost:9000/app-server-ifs/search/video";
//			json.put("lng", "113.93351");
//			json.put("lat", "22.525788");
//			json.put("distance", 2000);
//			json.put("user_id", "b594f5eb81d845fba03d4c9601f677bf");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testSearchUser() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			String url = "http://120.25.56.90:8081/app-server-search-api/search/user";
//			json.put("start", 0);
//			json.put("end", 100);
//			json.put("keyword", "13");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testInfoList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 size Y int 5 数量 2 receive_version Y int 1 接收版本 1:大众版 2:教练版 3
//			 * record_id N int 32 记录id,从第一条取传该值不用传
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9081/gcw/info/list";
//			String url = "http://192.168.1.247/gcw/info/list";
//			json.put("size", 10);
//			json.put("receive_version", 1);
//			json.put("keyword", "13");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGroupNotice() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * group_id Y String 32 群组ID notice_title N String 100
//			 * 公告标题,目前先不填写该字段 notic_content Y String 40 公告内容 user_id Y String Y
//			 * 发布人,用户ID.教练ID
//			 * 
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			String url = "http://120.25.56.90:9081/gcw/group/notice";
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("notice_title", "测试公告");
//			json.put("notic_content", "测试公告");
//			json.put("user_id", "c5e198c2d6664c37a4a2fd5873fd309f");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 查询学习视频/公告
//	 * 
//	 * @Title: testGroupNotice
//	 * @Description: TODO(这里用一句话描述这个方法的作用)
//	 * @Author: tsingning
//	 * @Since: 2016年3月9日下午5:37:28
//	 */
//	private static void testQueryVideoAndNotice() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * group_id Y String 32 群组ID notice_title N String 100
//			 * 公告标题,目前先不填写该字段 notic_content Y String 40 公告内容 user_id Y String Y
//			 * 发布人,用户ID.教练ID
//			 * 
//			 * 
//			 * 1457516147
//			 * 
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			String url = "http://120.25.56.90:9081/gcw/msg/notic_video";
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 查询学习视频
//	 * 
//	 * @Title: testGroupNotice
//	 * @Description: TODO(这里用一句话描述这个方法的作用)
//	 * @Author: tsingning
//	 * @Since: 2016年3月9日下午5:37:28
//	 */
//	private static void testQueryAddstudyVideo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 goup_id Y string 32 群组/舞队ID 2 size Y int 5 查询数量 3 video_id N
//			 * String 30 视频id 4 type N int 2 查询类型 1 向下查 2 向上查
//			 * 
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			String url = "http://120.25.56.90:8081/app-server-video-api/video/study/record/query";
//
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("size", 100);
//			json.put("type", 1);
//			JSONArray j = new JSONArray();
//			// j.add ("8654c78a62094d969dd6260a8a47e949");
//			// j.add ("f4f7625365f445d2933a0b2a3b05e280");
//			// json.put ("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 取服务器当前时间
//	 * 
//	 * @Title: testGroupNotice
//	 * @Description: TODO(这里用一句话描述这个方法的作用)
//	 * @Author: tsingning
//	 * @Since: 2016年3月9日下午5:37:28
//	 */
//	private static void testGetTime() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.104.68:7800/v1/gettime";
//			// String url = "http://120.25.56.90:7800/v1/gettime";
//			// String url = "http://120.25.56.90:7000/v1/gettime";
//			// String url =
//			// "http://100.98.3.203:8080/app-server-ifs/v1/gettime";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/gettime";
//			String url = "http://120.24.53.26:9080/v1/gettime";
//
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("user_id", "c5e198c2d6664c37a4a2fd5873fd309f");
//			JSONArray j = new JSONArray();
//			j.add("8654c78a62094d969dd6260a8a47e949");
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			json.put("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 取服务器当前时间
//	 * 
//	 * @Title: testGroupNotice
//	 * @Description: TODO(这里用一句话描述这个方法的作用)
//	 * @Author: tsingning
//	 * @Since: 2016年3月9日下午5:37:28
//	 */
//	private static void testUploadtoken() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.104.68:7800/v1/gettime";
//			// String url = "http://120.25.56.90:7800/v1/gettime";
//			// String url = "http://120.25.56.90:7000/v1/gettime";
//			// String url =
//			// "http://100.98.3.203:8080/app-server-ifs/v1/gettime";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/v1/get_upload_token";
//			String url = "http://120.25.56.90:7000/v1/get_upload_token";
//
//			json.put("type", "1");
//			json.put("cover_upload", "0");
//			JSONArray j = new JSONArray();
//			j.add("8654c78a62094d969dd6260a8a47e949");
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			json.put("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testAddstudyVideo() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			String url = "http://120.25.56.90:8081/app-server-video-api/video/study/record/add";
//
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("user_id", "c5e198c2d6664c37a4a2fd5873fd309f");
//			JSONArray j = new JSONArray();
//			j.add("8654c78a62094d969dd6260a8a47e949");
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			json.put("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotItemVideoDataList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			String url = "http://api.1758app.com/v1/hot/item/video";
//			// String url =
//			// "http://127.0.0.1:8080/app-server-video-api/video/get_edit_info";
//
//			json.put("item_id", "100022");
//			json.put("start", "1");
//			json.put("end", "100");
//			json.put("video_type", "1");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetVideoDataList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			// String url =
//			// "http://api.1758app.com/v1/search/video/keyword/list";
//			String url = "http://127.0.0.1:8080/app-server-video-api/video/get_edit_info";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			// String url =
//			// "http://api.1758app.com/v1/search/video/keyword/list";
//			String url = "http://120.25.56.90:8081/app-server-video-api/hot/item";
//			// String url = "http://120.25.56.90:7000/v1/hot/item";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetAudioList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			// String url =
//			// "http://api.1758app.com/v1/search/video/keyword/list";
//			String url = "http://120.25.56.90:8081/app-server-video-api/video/get_audio_list";
//
//			json.put("size", "100");
//			json.put("end", "100");
//			json.put("item_id", "1");
//			json.put("video_type", "2");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotGrooupList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			String url = "http://api.1758app.com/v1/hot/group";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-video-api/hot/group";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			json.put("item_id", "1");
//			json.put("video_type", "2");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotAudioVideoList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			String url = "http://api.1758app.com/v1/hot/audio/video";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-video-api/hot/audio/video";
//
//			json.put("start", "0");
//			json.put("end", "100");
//			json.put("audio_id", "12");
//			json.put("video_type", "1");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotAudioList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			// String url =
//			// "http://api.1758app.com/v1/search/video/keyword/list";
//			String url = "http://120.25.56.90:8081/app-server-video-api/hot/audio";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			json.put("item_id", "10");
//			json.put("video_type", "2");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetHotVideoList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			// String url =
//			// "http://api.1758app.com/v1/search/video/keyword/list";
//			String url = "http://120.25.56.90:8081/app-server-video-api/hot/item/video";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			json.put("item_id", "10");
//			json.put("video_type", "2");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("type", "1");
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testKeyWord() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/search/video/keyword/list";
//			String url = "http://api.1758app.com/v1/search/video/keyword/list";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-video-api/search/video/keyword/list";
//
//			json.put("start", "1");
//			json.put("end", "100");
//			JSONArray j = new JSONArray();
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetNation() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id8081/app-server-search-api/
//			 * 
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url =
//			// "http://120.25.56.90:9080/app-server-ifs/area/get_nation_list";
//			String url = "http://api.1758app.com/v1/area/get_nation_list";
//			// String url =
//			// "http://120.76.26.62:8081/app-server-search-api/area/get_nation_list";
//
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("user_id", "c5e198c2d6664c37a4a2fd5873fd309f");
//			JSONArray j = new JSONArray();
//			j.add("8654c78a62094d969dd6260a8a47e949");
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			json.put("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testVideoIndex() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.25.56.90:7000/v1/video/index ";
//
//			json.put("group_id", "794d29a0e73ce8a61428384b7b78c7dd");
//			json.put("user_id", "c5e198c2d6664c37a4a2fd5873fd309f");
//			JSONArray j = new JSONArray();
//			j.add("8654c78a62094d969dd6260a8a47e949");
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			json.put("video_ids", j);
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testVideoDetail() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.25.56.90:8081/app-server-api/user/add/coach";
//
//			json.put("group_id", "cc48c1e189d54d6c34950c7d580e8fed");
//			json.put("phone_number", "15002078832");
//			// json.put ("phone_number", "15813880586");
//			json.put("user_id", "cc7c180bd5e5479094647bcf13c4172f");
//			json.put("name", "15002078832");
//			JSONArray j = new JSONArray();
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testCommonList() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * c8dd6b56a8c0473f092cd4439f51921a
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.25.56.90:9081/gcw/comment/query";
//
//			json.put("user_id", "cc48c1e189d54d6c34950c7d580e8fed");
//			json.put("original_id", "c8dd6b56a8c0473f092cd4439f51921a");
//			// json.put ("phone_number", "15813880586");
//			json.put("size", "100");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetUploadToken() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-api/user/add/coach";
//			String url = "http://api.1758app.com/v1/get_upload_token";
//
//			json.put("type", "2");
//			// json.put ("phone_number", "13510356294");
//			json.put("cover_upload", "1");
//			// json.put ("phone_number", "13510356294");
//			// json.put ("phone_number", "15813880586");
//			json.put("user_id", "cc7c180bd5e5479094647bcf13c4172f");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetKeyWOrd() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			// String url =
//			// "http://120.25.56.90:8081/app-server-api/user/add/coach";
//			String url = "http://api.1758app.com/v1/search/video/keyword/list";
//
//			json.put("start", "1");
//			// json.put ("phone_number", "13510356294");
//			json.put("end", "100");
//			// json.put ("phone_number", "13510356294");
//			// json.put ("phone_number", "15813880586");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testSearchVideo1() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.25.56.90:8081/app-server-api/user/add/coach";
//
//			json.put("group_id", "cc48c1e189d54d6c34950c7d580e8fed");
//			// json.put ("phone_number", "13510356294");
//			json.put("phone_number", "15002078832");
//			// json.put ("phone_number", "13510356294");
//			// json.put ("phone_number", "15813880586");
//			json.put("user_id", "cc7c180bd5e5479094647bcf13c4172f");
//			json.put("name", "子雄");
//			JSONArray j = new JSONArray();
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testCommonLog() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 * 
//			 * 914e66557917354b64fb419bc6182d83
//			 * 
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.76.26.62:9081/gcw/comment/query";
//
//			json.put("user_id", "a97e94f86fa646489d1845d362d2e5a8");
//			json.put("original_id", "41403d410fb58432110525d02d4e2061");
//			json.put("size", "10000");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testAddMembers() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * 1 video_ids Y string 32 视频ID，JSON数组 2 user_id Y string 32 用户id 3
//			 * group_id Y string 32 舞队id
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://120.25.56.90:8081/app-server-api/user/add/coach";
//
//			json.put("group_id", "cc48c1e189d54d6c34950c7d580e8fed");
//			// json.put ("phone_number", "13510356294");
//			json.put("phone_number", "15002078832");
//			// json.put ("phone_number", "13510356294");
//			// json.put ("phone_number", "15813880586");
//			json.put("user_id", "cc7c180bd5e5479094647bcf13c4172f");
//			json.put("name", "子雄");
//			JSONArray j = new JSONArray();
//			j.add("f4f7625365f445d2933a0b2a3b05e280");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private static void testGetDJIMCommTime() {
//		try {
//			long time = System.currentTimeMillis();
//			System.out.println(time);
//			net.sf.json.JSONObject json = new net.sf.json.JSONObject();
//			// String url =
//			// "http://localhost:9000/app-server-ifs/user/check_login_id";
//			// {"lng":113.93351,"lat":22.525788,"distance":"2000","user_id":"b594f5eb81d845fba03d4c9601f677bf"}1457403634637eb69a806-ccfe-404e-a494-af7842bfb3bdgcw
//
//			/**
//			 * c8dd6b56a8c0473f092cd4439f51921a
//			 */
//			// String url =
//			// "http://120.25.56.90:8081/app-server-search-api/search/user";
//			// String url = "http://120.25.56.90:9080/app-server-ifs/video/index
//			// ";
//			String url = "http://im.d.plus/api/v1/gettime";
//
//			json.put("user_id", "cc48c1e189d54d6c34950c7d580e8fed");
//			json.put("original_id", "c8dd6b56a8c0473f092cd4439f51921a");
//			// json.put ("phone_number", "15813880586");
//			json.put("size", "100");
//			String jstr = json.toString();
//			jstr = jstr + time + time + "gcw";
//			String md5Value = MD5Util.getMD5(jstr);
//			System.out.println(md5Value);
//			JSONObject req = new JSONObject();
//			req.put("request_id", time);
//			req.put("timestamp", time);
//			req.put("sign", md5Value);
//			req.put("para_data", json);
//			req.put("type", "1");
//
//			System.out.println(req.toString());
//			String rs = HttpUtil.doPost(url, req.toString());
//			System.err.println(" 返回结果" + rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	// http://m.1758app.com/web/live
//
//	public static void testHTML() {
//		for (int i = 0; i < 1000000; i++) {
////			Thread t = new Thread(new Runnabel() {
////				public void run() {
////					System.out.println("Mythread 线程");
////				}
////			});
//
//			new Thread() {
//				public void run() {
//					 String rs;
//					try {
//						rs = HttpUtil.doGet("http://api.1758app.com/v1/channel/chart_list");
//						 System.err.println (" 返回结果" + rs);
//					} catch (MalformedURLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			
//					}
//			}.start();
//
//		}
//
//	}

}
