package com.cosmos.controller.user;



import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.cosmos.dto.*;
import com.cosmos.service.*;



@Controller
@RequestMapping(value="/tboard/")
public class TboardController{

	@Autowired
	private TboardService tboardService;
	
	private static final Logger log = LoggerFactory.getLogger(TboardController.class);
	
	@GetMapping("list")
	public void list(Model model) {
//		ArrayList<Board> b = boardService.getBoardList();//리스트 출력 따로 작업할 일이 없기 때문에 값을 변수에 담을 필요 없다	
		model.addAttribute("tboard", tboardService.getTboardList()); 
		
	}
	
	@GetMapping("regForm")
	public void regForm() {		
	}
	
	@PostMapping("register")
	public String register(Tboard tboard,HttpSession sess,RedirectAttributes rttr) {
		tboard.setId((String)sess.getAttribute("sess_id"));
		int tno = tboardService.insertTboard(tboard);	
		rttr.addFlashAttribute("tno",tno);
		return "redirect:/tboard/view";
	}	
	@GetMapping("view")
	public void view(@ModelAttribute("tno") int tno,Model model) {		
		model.addAttribute("tboard",tboardService.getTboard(tno));
	}

}