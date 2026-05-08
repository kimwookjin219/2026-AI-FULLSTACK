package com.the703.basic016_ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class JavaIOEx001 {
	public static void main(String[] args) throws IOException {
		// #1. 경로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss"); //포맷설정
		long millis = System.currentTimeMillis(); // 시스템 시간 가져오기
		String folder_rel = "src/com/the703/basic016_ex/";  // 상대경로- 현재작업 폴더기준
	    String file_path  = "app.log";
		
	    File folder = new File( folder_rel );
	    File file = new File( folder_rel + file_path );
	    
	    // #2. 파일+ 폴더 준비
	    if(!folder.exists()) { folder.mkdirs(); }
	    if(!file.exists()) { file.createNewFile(); }
	    
	    // #3. Char단위로 파일쓰기      Reader > [프로그램] ># Writer
	    // sdf.format(millis) + "로그파일입니다."   20260508_1716 로그파일입니다.
	    Writer writer = new FileWriter(file); 
	    
	    writer.write(sdf.format(millis) + " 로그파일입니다.");
	    writer.close();
	    
	    // #4. Char단위로 파일 읽기 
	    
	    Reader reader = new FileReader(file);
	    int cnt = 0;
	    while( ( cnt = reader.read() ) != -1) {  
	    	System.out.print((char)cnt);
	    } reader.close();

	}
}
