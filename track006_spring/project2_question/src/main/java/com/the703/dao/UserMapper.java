package com.the703.dao;
import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

@Mapper
public interface UserMapper { 
	
	public int      	 insert(UserDto dto);
	public int findLogin(UserDto dto);
	public UserDto findByUno(int uno);
	public String   findByEmail( String email);
	public String  findByNickname(   String nickname);
	
	public UserDto  findByEmailUserInfo(   String email);
	public     AuthUserDto    readAuth(String email);	
	public  int          insertAuth(AuthDto  dto);
	
}
