//package platform.console.account.service.test;
//
///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        /**
//         * {
//"timestamp":"1453798193112",
//"request_id":"1453798193112",
//"sign":"",
//"para_data":{ 
//  "user_id":"123",
//  "para1":"value1",
//  "para2":"value2",
//  "para3":"value3",
//  }
//}
//      Md5(json.get(“para_data”).toString+timestamp+request_id+ gcw)
//         *
//         */
//        long time = System.currentTimeMillis ();
//        System.out.println(time);
//        net.sf.json.JSONObject json = new net.sf.json.JSONObject ();
//        String url = "http://7xqonz.media1.z0.glb.clouddn.com/gxfc.mp4";
//        json.put ("user_id","935addc386324475b42e8d9c6f6ca55e");
//        json.put ("type", "1");
//        String  jstr = json.toString ();
//        jstr = jstr+time+time+"gcw"+"05ddbc092a0249ecb0b29c6eb3642b7e";
//        System.out.println (jstr);
//        System.out.println (MD5Util.getMD5 (jstr));
////  user_id=935addc386324475b42e8d9c6f6ca55e取到的token值为87f5456b9d4f4bfea9526ae104380b31        
//        
//// dd32497434b74b74afbf18eb48f48c9b       
//// {"sign":"9516BF49DEA1D74CDFEB0EE32795C6F6","timestamp":"1455789633622","request_id":"pqTVGD-00","para_data":{"user_id":"3e38eb3ec9e14f349d14d6942e16ac4c","size":"10"}}        
//// {"user_id":"9f9dfd775fe54ae9ae9c3a3f9c285673","type":"1","cover_upload":"0"}14557131668031455713166803gcwdd32497434b74b74afbf18eb48f48c9b
//// {"user_id":"9f9dfd775fe54ae9ae9c3a3f9c285673","cover_upload":"0","type":"1"}14557131668031455713166803gcwdd32497434b74b74afbf18eb48f48c9b        
//        
//        long l =System.currentTimeMillis ();
//        l = l -1453864296946l;
//        
//        System.out.println (System.currentTimeMillis ()-1453864296946l);
//        System.out.println (MD5Util.getMD5 ("111111"));
//        
//        
//    }
//}
