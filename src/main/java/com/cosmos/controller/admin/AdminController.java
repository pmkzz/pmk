package com.cosmos.controller.admin;

import java.util.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.mvc.support.*;

import com.cosmos.controller.user.HomeController;
import com.cosmos.dto.*;
import com.cosmos.service.*;



@Controller
@RequestMapping(value="/")
public class AdminController{
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private MemberService memberService;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@PostMapping("login")
	public String login(String id, String pw, HttpSession sess,Model model) {
		Map<String,String> map =loginService.loginService(id, pw);
		log.info("login : " + id);
		log.info("login : " + pw);
		
		String viewPage =null;
		System.out.println(map.get("stat"));
		switch(map.get("stat")){
		
		case "0": //로그인 성공, 세션값 설정			
			sess.setAttribute("sess_id", id);
			sess.setAttribute("sess_name", map.get("name"));
			int cnt = loginService.getMemberCnt();
			sess.setAttribute("cnt", cnt);
			int isdelCnt = loginService.isdelMemberCnt();
			sess.setAttribute("isdelCnt", isdelCnt);
			viewPage = "/admin_main";
			
			break;			
		default : //id 없는 경우, 패스워드 불일치
			model.addAttribute("loginStat","loginfail");
			viewPage ="index";
		}
		return viewPage;
	}
	@PostMapping("main")
	public String main(HttpSession sess,Model model) {		
		int cnt = loginService.getMemberCnt();
		sess.setAttribute("cnt", cnt);
		int isdelCnt = loginService.isdelMemberCnt();
		sess.setAttribute("isdelCnt", isdelCnt);		
		return"/admin_main";
	}
	
	@PostMapping("noticeList")
	public void noticeList(Model model) {
		model.addAttribute("notice", noticeService.getNoticeList());
	}
	@PostMapping("memberList")
	public void memberList(Model model) {
		
	}

}