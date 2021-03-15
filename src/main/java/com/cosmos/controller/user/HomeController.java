package com.cosmos.controller.user;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.cosmos.dto.*;
import com.cosmos.service.*;




@Controller
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute("resMsg") String msg) {
		model.addAttribute("notice", noticeService.getNoticeList());		
		model.addAttribute("resMsg", msg);
		return "index";
		
	}
	
}
