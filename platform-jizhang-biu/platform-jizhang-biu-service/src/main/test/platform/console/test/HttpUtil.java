package platform.console.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

    final static String charsetName = "UTF-8";

    public static String doGet(String url) throws MalformedURLException,IOException{
        HttpURLConnection urlconn = null;
        urlconn = (HttpURLConnection) new URL (url).openConnection ();
        urlconn.getRequestProperties ();
        urlconn.setRequestProperty ("content-type", "text/html");
        urlconn.setRequestMethod ("GET");
        urlconn.setConnectTimeout (10000);
        urlconn.setReadTimeout (10000);
        urlconn.setDoInput (true);

        BufferedReader rd = new BufferedReader (new InputStreamReader (urlconn.getInputStream (),charsetName));

        String temp = null;
        StringBuffer sb = new StringBuffer ();
        temp = rd.readLine ();
        while (temp != null) {
            sb.append (temp);
            temp = rd.readLine ();
        }
        rd.close ();
        urlconn.disconnect ();

        return sb.toString ();
    }

    public static String doPost(String url,String value) throws MalformedURLException,IOException{
        HttpURLConnection urlconn = null;
        urlconn = (HttpURLConnection) new URL (url).openConnection ();
        urlconn.getRequestProperties ();
        urlconn.setRequestProperty ("content-type", "application/json");
        urlconn.setRequestMethod ("POST");
        urlconn.setConnectTimeout (10000);
        urlconn.setReadTimeout (10000);
        urlconn.setDoInput (true);
        urlconn.setDoOutput (true);
        urlconn.getOutputStream ().write (value.getBytes ());
        urlconn.getOutputStream ().close ();

        BufferedReader rd = new BufferedReader (new InputStreamReader (urlconn.getInputStream (),charsetName));

        String temp = null;
        StringBuffer sb = new StringBuffer ();
        temp = rd.readLine ();
        while (temp != null) {
            sb.append (temp);
            temp = rd.readLine ();
        }
        rd.close ();
        urlconn.disconnect ();

        return sb.toString ();
    }
}
