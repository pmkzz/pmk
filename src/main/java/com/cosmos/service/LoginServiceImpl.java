package com.cosmos.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.cosmos.dao.*;


@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	
	LoginDao ldao;
		
	@Override
	public Map<String, String> loginService(String id, String pw) {
		 
		Map<String,String>map = ldao.loginProc(id, pw);
		return ldao.loginProc(id,pw);
	}

	@Override
	public int getMemberCnt() {
				 
		return ldao.getMemberCnt();
	}

	@Override
	public int isdelMemberCnt() {
		 
		return ldao.isdelMemberCnt();
	}

}
