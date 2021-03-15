package com.cosmos.controller.user;

import java.lang.ProcessBuilder.*;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.cosmos.dto.*;

@Controller
public class SampleController {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public String doA() {
		log.info("doA called...");
		
		return "sample/doA";
	}
	
	@RequestMapping("doB")
	public String doB(@ModelAttribute("msg") String msg, Model modal) {
		log.info("doB called...{}",msg);
		
		msg+=" 반갑습니다";
		Member m = new Member();
		m.setId("pmk");
		m.setName("홍길동");
		
		modal.addAttribute("msg",msg);
		modal.addAttribute("member",m);
		return "sample/doB";
	}
	@RequestMapping("doC")
	public String doC(RedirectAttributes rttr) {
		log.info("doC called..");
		
		rttr.addFlashAttribute("msg","who am i??");
		return "redirect:/doD";
	}
	@RequestMapping("doD")
	public String doD(Model model, @ModelAttribute("msg") String msg) {
		log.info("doC called..{}",msg);
		model.addAttribute("msg",msg);
		
		return "sample/doD";
	}
	@RequestMapping("doE")
	public ModelAndView doE() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sample/doList");
		mv.addObject("msg","this is here!");
		
		return mv;
	}
	
	@RequestMapping("doJSON")
	public @ResponseBody Board doJson() {
		Board b = new Board();
		b.setTitle("1");
		b.setContent("1,2,3,4,");
		b.setId("pppp");
		return b;
	}

}
