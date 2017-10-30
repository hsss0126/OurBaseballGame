package net.skhu.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class MyConnection {

	/**
	 * 로그인/중복확인 연결메소드
	 * @param nickName / password
	 * @return 결과값
	 */
	@SuppressWarnings("unchecked")
	public String loginConnection(String ...arg) {
		URL url;
		HttpURLConnection conn = null;
		String result;
		try {
			url = new URL(URLs.url+"user/login");
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(10000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			System.out.println("연결 세팅");
			
			JSONObject json = new JSONObject();
			json.put("nickName", arg[0]);
			json.put("password", arg[1]);
			System.out.println(json.toString());
			
			OutputStream out = conn.getOutputStream();
			System.out.println("아웃풋 연결");
			out.write(json.toString().getBytes());
			out.flush();
			out.close();
			System.out.println("json전송");
			System.out.println(conn.getResponseCode());
			if(conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while((result = br.readLine())!=null) {
					System.out.println(result);
					return result;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = Integer.toString(ResponseCode.connect_error);
		return result; 	
	}
	
	@SuppressWarnings("unchecked")
	public String joinConnection(String ...arg) {
		URL url;
		HttpURLConnection conn = null;
		String result;
		try {
			url = new URL(URLs.url+"user/create");
			conn = (HttpURLConnection) url.openConnection();
			
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(10000);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			System.out.println("연결 세팅");
			
			JSONObject json = new JSONObject();
			json.put("nickName", arg[0]);
			json.put("password", arg[1]);
			System.out.println(json.toString());
			
			OutputStream out = conn.getOutputStream();
			System.out.println("아웃풋 연결");
			out.write(json.toString().getBytes());
			out.flush();
			out.close();
			System.out.println("json전송");
			System.out.println(conn.getResponseCode());
			if(conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while((result = br.readLine())!=null) {
					System.out.println(result);
					return result;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = Integer.toString(ResponseCode.connect_error);
		return result; 	
	}
}
