package com.cosmos.controller.user;


import java.util.*;


import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.cosmos.dto.*;
import com.cosmos.service.*;



@Controller
public class MemberController{
	
	
	//의존성 주입, Spring bean 관리
	@Autowired
	private MemberService memberService;
	@Autowired
	private CodeService code;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@PostMapping("member/login")
	public String login(Member member, HttpSession sess, Model model){
		log.info("member : " + member.getId());
		log.info("member : " + member.getPw());
		
		Map<String,String> map =memberService.loginservice(member);
		
		String viewPage =null;
		switch(map.get("stat")){
		
		case "0": //로그인 성공, 세션값 설정			
			sess.setAttribute("sess_id", member.getId());
			sess.setAttribute("sess_name", map.get("name"));
			viewPage = "redirect:/";
//			sess.setAttribute("sess_name", name);
			break;			
		default : //id 없는 경우, 패스워드 불일치
			model.addAttribute("loginStat","loginfail");
			viewPage ="index";
		}
			return "redirect:/";
	}
	
	@GetMapping("member/myPage")
	public void mypage(Model model,HttpSession sess) {
		Member m = memberService.getMember(sess.getAttribute("sess_id").toString());
		model.addAttribute(m);
		model.addAttribute("hobby",code.getCodeList("hobby"));
				
	}
		
	@GetMapping("member/logOut")
	public String logout(HttpSession sess){		
		sess.invalidate();
		
		return "redirect:/";
	}
	
	@PostMapping("member/memberModify")
	public String modify(Member m, Model model) {
		int rs =memberService.update(m);
		System.out.println(rs);
		if(rs>0) {
			model.addAttribute(m);			
			model.addAttribute("hobby",code.getCodeList("hobby"));
		}		
		return "member/memModifyView";
		
	}
	
	@GetMapping("member/delete")
	public String delete(HttpSession sess) {		
		
		 memberService.delete(sess.getAttribute("sess_id").toString());
				
		sess.invalidate();
		return "redirect:/";
//		return "redirect:/member/logout";
	}
	@GetMapping("member/memRegForm")
	public String memReg() {
		return "member/memRegForm";		
	}
	
	@PostMapping("member/memberInsert")
	public String insert(Member m, RedirectAttributes rttr) {
		int rs = memberService.insert(m);
		rttr.addAttribute("resMsg", rs);
		
		return "redirect:/";
	}
	
	@PostMapping("member/idDoubleCheck")
	public ResponseEntity<String> idDoubleCheck(@RequestParam("id") String id){
		log.info("idCheck called...id : " + id);
		String rs = Integer.toString(memberService.idDoubleCheck(id));
		return new ResponseEntity<String>(rs , HttpStatus.OK);
	}
	
//	
//	private void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		
//		response.setContentType("text/html; charset=utf-8");
//		request.setCharacterEncoding("utf-8");
//		
//		PrintWriter out = response.getWriter();
////		w.append("<HTML><BODY><H2>회원관리서비스</H2></body><HTML>");
//		
//		String uri = request.getRequestURI();
//		String cmd = uri.substring(uri.lastIndexOf("/")+1);
//		
//		System.out.println("URI :" + cmd);
//		String viewPage = null;
//		
//		if(cmd.equals("memReg.me")) { //회원등록
//			
//			viewPage = "/WEB-INF/views/user/member/memRegForm.jsp";
//			
//			goView(request,response,viewPage);
//		}else if(cmd.equals("memInsert.me")) { //회원등록 처리 요청
//						
//			ms.insert(request);
//			
////			request.getSession().setAttribute("isMemRegSuccess", 1);
//			response.sendRedirect("/WEB-INF/views/user/index.jsp?isMemRegSuccess=1");
//			
////			request.setAttribute("isMemRegSuccess", 1);
////			goView(request, response, "/");
//		
//		}else if(cmd.equals("idCheck.me")) { //아이디 중복검사
//			
//			String id = request.getParameter("id");
//			int rs = ms.idDoubleCheck(id); //memberServiceImpl 수정 필요
//			System.out.println(rs);
//			out.print(Integer.toString(rs));
//					
//		}else if(cmd.equals("logOut.me")) {
//			//세션파괴하고 루트분기
//			HttpSession sess = request.getSession();
//			sess.invalidate();
//			response.sendRedirect("/");
//		}else if(cmd.equals("myPage.me")) {
//			Member m = ms.getMember(request.getSession().getAttribute("sess_id").toString());
//			request.setAttribute("member", m);
//			CodeService code = new CodeServiceImpl();
//			request.setAttribute("hobby", code.getCodeList("hobby"));
//			goView(request,response,"/WEB-INF/views/user/member/myPage.jsp");
//		}else if(cmd.equals("memberModify.me")) {
//			//회원수정처리			
//			Member m = ms.update(request);
//			
//			request.setAttribute("member", m);
//			goView(request, response, "/WEB-INF/views/user/member/memModifyView.jsp");
//			
//			
//		}
//
//				
//	}
//
//
//
//
//	private void goView(HttpServletRequest request, HttpServletResponse response, String viewPage) throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
//		rd.forward(request, response);
//		
//	}
}
