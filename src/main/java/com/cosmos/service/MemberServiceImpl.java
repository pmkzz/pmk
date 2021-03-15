package com.cosmos.service;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import com.cosmos.dao.*;
import com.cosmos.dto.*;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao mdao;

	@Override
	public int insert(Member m) {
		String email =m.getEid() + "@" + m.getDomain();
	    m.setEmail(email);
		return mdao.insertMember(m);
	}
	

	@Override
	public int update(Member m) {		
		String email =m.getEid() + "@" + m.getDomain();
	    m.setEmail(email);
		return mdao.updateMember(m);
	}

	@Override
	public int delete(String id) {
		return mdao.deleteMember(id);
	}

	@Override
	public Member[] select() {
		return mdao.getMemberList();
	}

	@Override
	public Map<String,String> loginservice(Member member) {
		
		Map<String,String> map = mdao.loginProc(member);
		return mdao.loginProc(member);
	}

	@Override
	public Member getMember(String id) {

		return mdao.getMember(id);
		
	}

	@Override
	public int idDoubleCheck(String id) {
		 
		return mdao.idDoubleCheck(id);
	}
	
	

}
