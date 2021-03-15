package com.cosmos.service;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.ui.*;

import com.cosmos.dto.*;



public interface MemberService {

	//회원등록
	int insert(Member m);
	
	//회원수정
	int update(Member m);
	
	//회원삭제
	int delete(String id);
	
	//회원조회
	Member[] select();
	
	//로그인
	Map<String,String> loginservice(Member member);

	
	//1인회원조회
	Member getMember(String id);
	
	//아이디 체크
	int idDoubleCheck(String id);

		
}
