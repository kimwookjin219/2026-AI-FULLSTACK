package com.the703.basic016;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class JavaIO004_img {
	public static void main(String[] args) throws IOException {
		// #1. 경로
		String origin = "src/com/the703/basic016/heal.jpg";
		String target1 = "src/com/the703/basic016/heal1.jpg";
		String target2 = "src/com/the703/basic016/heal2.jpg";
		
		// #2. byte 이미지파일 원본 읽어들여서 쓰기
		// InputStream  >  [프로그램] >  OutputStream
		InputStream bis = new FileInputStream(origin);      // 원본 읽어들이기     (read)
		OutputStream bos = new FileOutputStream(target1);   // heal1.jpg 쓰기   (write)
		
		int cnt1 = 0;
		while( (cnt1 = bis.read())!= -1 ) {
			bos.write( (byte)cnt1 );
		}
		bos.close(); bis.close();
		System.out.println(">> byte 이미지 복사 완료");
		// #3. char 이미지파일 원본 읽어들여서 쓰기
		// Reader > [프로그램] > Writer
		Reader cr = new FileReader(origin);
		Writer cw = new FileWriter(target2);
		
		int cnt2 = 0;
		while( (cnt2 = cr.read())!= -1 ) {
			cw.write( (char)cnt2 );
		}
		cw.close(); cr.close();
		System.out.println(">> char 이미지 복사 완료");
	}
}
