package com.cosmos.service;

import java.util.*;


public interface LoginService {
	
	Map<String,String> loginService(String id,String pw);

	int getMemberCnt();

	int isdelMemberCnt();

}
