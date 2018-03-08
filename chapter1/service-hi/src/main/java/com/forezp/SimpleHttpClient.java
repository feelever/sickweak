package com.forezp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpClient {
	public static String sendPost(String uri, String charset) {
		String result = null;
		InputStream in = null;
		 try {  
	            URL url = new URL(uri);  
	            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();  
	            urlcon.setRequestMethod("POST");
	            urlcon.connect();// 获取连接  
	            in = urlcon.getInputStream();  
	            BufferedReader buffer = new BufferedReader(new InputStreamReader(  
	                    in, charset));  
	            StringBuffer bs = new StringBuffer();  
	            String line = null;  
	            while ((line = buffer.readLine()) != null) {  
	                bs.append(line);  
	            }  
	            result = bs.toString();  
	        } catch (Exception e) {  
	            System.out.println("[请求异常][地址：" + uri + "][错误信息：" + e.getMessage()  
	                    + "]");  
	        } finally {  
	            try {  
	                if (null != in)  
	                    in.close();  
	            } catch (Exception e2) {  
	                System.out.println("[关闭流异常][错误信息：" + e2.getMessage() + "]");  
	            }  
	        }  
	        return result;  
	}
	public static String sendGet(String uri, String charset) {
		String result = null;
		InputStream in = null;
		 try {  
	            URL url = new URL(uri);  
	            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();  
	            urlcon.setRequestMethod("GET");
	            urlcon.connect();// 获取连接  
	            in = urlcon.getInputStream();  
	            BufferedReader buffer = new BufferedReader(new InputStreamReader(  
	                    in, charset));  
	            StringBuffer bs = new StringBuffer();  
	            String line = null;  
	            while ((line = buffer.readLine()) != null) {  
	                bs.append(line);  
	            }  
	            result = bs.toString();  
	        } catch (Exception e) {  
	            System.out.println("[请求异常][地址：" + uri + "][错误信息：" + e.getMessage()  
	                    + "]");  
	        } finally {  
	            try {  
	                if (null != in)  
	                    in.close();  
	            } catch (Exception e2) {  
	                System.out.println("[关闭流异常][错误信息：" + e2.getMessage() + "]");  
	            }  
	        }  
	        return result;  
	}
	public static String sendPost(String uri, String param, String charset) {  
        String result = null;  
        PrintWriter out = null;  
        InputStream in = null;  
        try {  
            URL url = new URL(uri);  
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();  
            urlcon.setDoInput(true);  
            urlcon.setDoOutput(true);  
            urlcon.setUseCaches(false);  
            urlcon.setRequestMethod("POST");  
            urlcon.connect();// 获取连接  
            out = new PrintWriter(urlcon.getOutputStream());  
            out.print(param);  
            out.flush();  
            in = urlcon.getInputStream();  
            BufferedReader buffer = new BufferedReader(new InputStreamReader(  
                    in, charset));  
            StringBuffer bs = new StringBuffer();  
            String line = null;  
            while ((line = buffer.readLine()) != null) {  
                bs.append(line);  
            }  
            result = bs.toString();  
        } catch (Exception e) {  
            System.out.println("[请求异常][地址：" + uri + "][参数：" + param + "][错误信息："  
                    + e.getMessage() + "]");  
        } finally {  
            try {  
                if (null != in)  
                    in.close();  
                if (null != out)  
                    out.close();  
            } catch (Exception e2) {  
                System.out.println("[关闭流异常][错误信息：" + e2.getMessage() + "]");  
            }  
        }  
        return result;  
    }  

	public static void main(String[] args) {
		SimpleHttpClient.sendGet("http://www.baidu.com", "UTF-8");
	}
}
