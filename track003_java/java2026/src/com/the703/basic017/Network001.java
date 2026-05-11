package com.the703.basic017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Network001 {
	public static void main(String[] args) {
		
		try {
			//1. Url
			URL url = new URL("https://www.google.com/");
			//2. 연결객체 (HttpUrlConnection)
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//3. 요청설정 (Request)
			conn.setRequestMethod("GET");  //GET 주소표시창에 자원요청(노출)
			//4. 응답설정 (Response)
			int code = conn.getResponseCode();
			System.out.println(code);  // 200 응답성공! , 404 페이지 없음 , 500 오류
			//5. 응답데이터 
			// BufferedReader # > [프로그램 Network001.java]  >  BufferedWriter
			BufferedReader br;
			if(code==200) { 
				//   한 줄씩 읽을 수 있도록 속도향상 - 바이트스트림을 문자스트림 - 응답데이터스트림
				br = new BufferedReader(new InputStreamReader( conn.getInputStream() ));
			}
			else { 
				br = new BufferedReader(new InputStreamReader( conn.getErrorStream() ));
			}
			String line = ""; StringBuffer sb = new StringBuffer();
			while( ( line = br.readLine() ) != null ) { sb.append(line+"\n"); }
			System.out.println(sb.toString());
			br.close(); conn.disconnect();
			
			
		} catch (MalformedURLException e) {  e.printStackTrace(); } 
		  catch (IOException e) {  e.printStackTrace(); } 
		
		
	}
}
/*
Network

1) web (http 통신)  →  jsp (java + html)   →  Spring
2) socket

*/