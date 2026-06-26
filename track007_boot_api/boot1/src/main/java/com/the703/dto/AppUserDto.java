package com.the703.dto;

import lombok.Data;

@Data
public class AppUserDto {
	private Integer appUserId;
	private String email;
	private String password;
	private Integer mbtiTypeId;
	private String createdAt;
	private String ufile;
	private String mobile;
	private String nickname;
	private String provider;
	private String providerId;
}
/*
 APPUSER
 ┌───────────────────────────────────────────────┐
 │ APP_USER_ID (PK)                              │
 │ EMAIL (NOT NULL, UNIQUE with PROVIDER)        │
 │ PASSWORD                                      │
 │ MBTI_TYPE_ID                                  │
 │ CREATED_AT                                    │
 │ UFILE                                         │
 │ MOBILE                                        │
 │ NICKNAME                                      │
 │ PROVIDER (NOT NULL)                           │
 │ PROVIDER_ID                                   │
 └───────────────────────────────────────────────┘
                ▲
                │  (FK: APP_USER_ID)
                │
 AUTHORITIES
 ┌───────────────────────────────────────────────┐
 │ AUTH_ID (PK)                                  │
 │ EMAIL                                         │
 │ AUTH (NOT NULL, UNIQUE with APP_USER_ID)      │
 │ APP_USER_ID (FK → APPUSER.APP_USER_ID)        │
 └───────────────────────────────────────────────┘
````

SQL> desc appuser;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
APP_USER_ID                               NOT NULL NUMBER(5)
EMAIL                                     NOT NULL VARCHAR2(100)
PASSWORD                                           VARCHAR2(100)
MBTI_TYPE_ID                                       NUMBER(3)
CREATED_AT                                         DATE
UFILE                                              VARCHAR2(255)
MOBILE                                             VARCHAR2(50)
NICKNAME                                           VARCHAR2(50)
PROVIDER                                  NOT NULL VARCHAR2(50)
PROVIDER_ID                                        VARCHAR2(100)

SQL> desc authorities;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 AUTH_ID                                   NOT NULL NUMBER(5)
 EMAIL                                              VARCHAR2(255)
 AUTH                                      NOT NULL VARCHAR2(255)
 APP_USER_ID                                        NUMBER(5)

SQL>

*/