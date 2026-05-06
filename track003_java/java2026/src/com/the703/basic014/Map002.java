package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Map002 {
	public static void main(String[] args) {
		Map<String, UserDTO> maps = new HashMap<>();
		maps.put("first", new UserDTO("first@gmail.com"));
		maps.put("second", new UserDTO("second@gmail.com"));
		maps.put("third", new UserDTO("third@gmail.com"));
		maps.put("third", new UserDTO("33@gmail.com"));
		maps.put("third", new UserDTO("33@gmail.com"));
		
		System.out.println("몇명? " + maps.size()); // 3
		System.out.println("몇명? " + maps);        
		// {third=UserDTO [no=5, email=33@gmail.com], 
		// first=UserDTO  [no=1, email=first@gmail.com], 
		// second=UserDTO [no=2, email=second@gmail.com]}
		
		//1. maps.entrySet() 이용해서 향상된 for로 출력
		for( Entry<String, UserDTO> u : maps.entrySet() ) { 
			String key = u.getKey();
			UserDTO value = u.getValue();
			
			System.out.println( "nickname : " + key+ ", email : " + value.getEmail() );
		}
		
		//2. maps.entrySet() 이용해서 Iterator로 출력  {iterator() , hasNext(), next()}		
		Iterator<Entry<String, UserDTO>> iter = maps.entrySet().iterator();
		while( iter.hasNext() ) { // 처리대상 확인
			Entry<String, UserDTO> m = iter.next(); 
			String key = m.getKey();
			UserDTO value = m.getValue();
			
			System.out.println( "nickname : " + key+ ", email : " + value.getEmail() );
		}

	}
}
