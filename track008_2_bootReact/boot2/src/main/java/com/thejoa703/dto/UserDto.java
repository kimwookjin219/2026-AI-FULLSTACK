package com.thejoa703.dto;

import java.time.LocalDateTime;

import com.thejoa703.entity.AppUser;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//1) UserDto : UserRequestDto / UserResponseDto 
//UserRequestDto  < email, password, nickname, *image(ufile: Multipart 빠짐) / provider, mobile, mbtitype>
//UserResponseDto < email,     role, nickname, ufile / provider >
//
//2) LoginRequest < email, password, provider >

public class UserDto {
	
	// 회원가입 요청 Dto
	@NoArgsConstructor
	@AllArgsConstructor
	@Setter @Getter
	public static class UserRequestDto{
		
		@Email
		@NotBlank // 화면단에서 꼭 받아야하는 내용
		private String  email;
		
		@NotBlank
		private String  password;
		
		@NotBlank
		private String  nickname;
		private String  provider; // local 기본
		private String  mobile;
		private Integer mbtitype;
	}
	
	// 회원정보 - 응답 Dto - react(front)로 넘김
	@Getter @Setter 
	@Builder 
	@NoArgsConstructor @AllArgsConstructor
	public static class UserResponseDto{ 
		private Long    id;
		private String  email;
		private String  nickname;
		private String  mobile;     // 나중에 저장용도
		private Integer mbtitype;   // 나중에 저장용도
		private String  role;
		private String  provider;
		private String  ufile;
		private LocalDateTime createdAt;
		
		public static UserResponseDto fromEntity(AppUser user) { // repository에서 처리해준 값 
			return UserResponseDto.builder()
					.id(user.getId())
					.email(user.getEmail())
					.nickname(user.getNickname())
					.provider(user.getProvider())
					.role(user.getRole())
					.createdAt(user.getCreatedAt())
					.ufile(user.getUfile())
					.build();
		}
		public AppUser toEntity() {
            AppUser user = new AppUser();
            user.setId(this.id);
            user.setEmail(this.email);
            user.setNickname(this.nickname);
            user.setProvider(this.provider != null ? this.provider : "local");
            user.setRole(this.role != null ? this.role : "ROLE_USER");
            user.setUfile(this.ufile);
            return user;
        }
		
		public UserResponseDto(AppUser user) { // insert,update 결과물
			this.id = user.getId();
			this.email = user.getEmail();
			this.nickname = user.getNickname();
			this.mobile = user.getMobile();
			this.mbtitype = user.getMbtitype();
			this.role = user.getRole();
		}
	}
}
