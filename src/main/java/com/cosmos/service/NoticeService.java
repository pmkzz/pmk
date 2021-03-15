package com.cosmos.service;

import java.util.*;

import com.cosmos.dto.*;



public interface NoticeService {

	ArrayList<Notice> getNoticeList();

	Notice getNotice(int nno);

}
