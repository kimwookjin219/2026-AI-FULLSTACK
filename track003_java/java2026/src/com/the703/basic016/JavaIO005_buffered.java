package com.the703.basic016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaIO005_buffered {
	public static void main(String[] args) throws IOException {
		// #1. 경로		
		String folder_rel = "src/com/the703/basic016/";  // 상대경로- 현재작업 폴더기준
		String file_path  = "io005_buffered.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel + file_path);
		
		// #2. 폴더 + 파일 만들기 { mkdirs / creatNewFile }
		
		if(!folder.exists()) { folder.mkdirs(); }
		if(!file.exists()) { file.createNewFile(); }
		
		System.out.println("폴더 파일 준비완료!"); // ctrl + f11  * 새로고침(f5) 해줘야함
		
		// #3. 파일쓰기 InputStream > [프로그램] > # OutputStream
		//1) new FileOutputStream(file)  byte
		//2) new OutputStreamWriter( 인코딩에 맞춰서 문자로(자료형) )
		//3) new BufferedWriter( 속도향상 )  (abc -> abc)		
		BufferedWriter bw = 
				new BufferedWriter( new OutputStreamWriter (  new FileOutputStream(file)  ) );
		
		bw.write("1,white,1200\n");
		bw.write("2,choco,1500\n");
		bw.write("3,banana,1800\n");
		bw.close();
		
		System.out.println("쓰기완료");
		
		// #4. 파일읽기 InputStream # > [프로그램] > OutputStream 
		BufferedReader br = 
				new BufferedReader( new InputStreamReader (  new FileInputStream(file)  ) );
		String line="";
		//StringBuffer sb = new StringBuffer();
		
		while( ( line = br.readLine() ) != null ) {
			System.out.println(line);
		}
		br.close();
		
	}
}
/*
1.Java I/O
- 입력(Input)과 출력(Output)
- 두 대상 간의 데이터를 주고 받는 것
- 스트림이란? 사용 연결통로

   입력스트림     →     [프로그램]      →      출력스트림
     InputStream                       OutputStream
     Reader                            Writer
     
2. Java I/O 분류
- byte (모든 종류 - 그림, 멀티미디어, 문자) / char(문자)
- byte ( InputStream/OutputStream ) / char ( Reader / Writer )

3. 보조스트림
- 스트림이란? 네트워크, 파일, 문자..... 사용 연결통로
- new BufferdReader( new InputStreamReader( new FileInputStreamReader(file) ) )

- 1) new FileStreamReader(file) - byte  (0101....)
- 2) new InputStreamReader      - 바이트를 [문자]스트림으로 , 인코딩
- 3) new BufferdReader          - 속도향상 , ( a → a (X) , abc → abc (O) )

*/