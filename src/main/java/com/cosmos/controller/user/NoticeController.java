package com.cosmos.controller.user;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.cosmos.service.*;



@Controller
@RequestMapping(value="/notice/")
public class NoticeController{
	
	@Autowired
	private NoticeService noticeService;
	
	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);
	
	@GetMapping("list")
	public void list(Model model) {
//		ArrayList<Board> b = boardService.getBoardList();//리스트 출력 따로 작업할 일이 없기 때문에 값을 변수에 담을 필요 없다	
		model.addAttribute("notice", noticeService.getNoticeList());	
	}
	@GetMapping("view")
	public void view(int nno,Model model) {
		model.addAttribute("notice",noticeService.getNotice(nno));
	}

}