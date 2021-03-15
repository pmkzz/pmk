package com.cosmos.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.cosmos.dao.*;
import com.cosmos.dto.*;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	BoardDao dao;
	
	@Override
	public ArrayList<Notice> getNoticeList() {
		 
		return dao.getNoticeList();
	}
	@Override
	public Notice getNotice(int nno) {
		 
		return dao.getNotice(nno);
	}
	
}
