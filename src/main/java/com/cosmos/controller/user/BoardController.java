package com.cosmos.controller.user;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;
import org.springframework.web.servlet.mvc.support.*;

import com.cosmos.dto.*;
import com.cosmos.service.*;



@Controller
@RequestMapping(value="/board/")
public class BoardController{
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private FileService fileService;

	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@GetMapping("list")
	public void list(Model model) {
//		ArrayList<Board> b = boardService.getBoardList();//리스트 출력 따로 작업할 일이 없기 때문에 값을 변수에 담을 필요 없다	
		model.addAttribute("board", boardService.getBoardList()); 
		
	}
	
	@GetMapping("regForm")
	public void regForm() {
		
	}
	
	@PostMapping("register")
	public String register(Board board, MultipartFile files, HttpSession sess, RedirectAttributes rttr) {
		log.info("제목 : "+ board.getTitle());
		log.info("제목 : "+ board.getContent());
		
		log.info("첨부파일 이름 : " + files.getOriginalFilename());
		log.info("첨부파일 크기 : " + files.getSize());
		log.info("첨부파일 타입 : " + files.getContentType());
		
		board.setId((String)sess.getAttribute("sess_id"));
		int bno =boardService.insertBoard(board);		
		fileService.fileUpload(sess, files, bno);
		
		rttr.addFlashAttribute("bno",bno);
		
		return "redirect:/board/view";
	}
	
	@GetMapping("view")
	public void view(@ModelAttribute("bno") int bno,Model model) {
		log.info("보드 번호 : "+ bno);		
		model.addAttribute("board",boardService.getBoard(bno));		
	}
	
	@PostMapping("modifyForm")
	public void modifyForm(Board board,UploadFile files,Model model) {
		model.addAttribute("board",board);
		model.addAttribute("uploadFile",files);
	}
	
	@PostMapping("modify")
	public String modify(Board board,HttpSession sess, MultipartFile files, RedirectAttributes rttr){
		boardService.updateBoard(board);
		int bno = board.getBno();
		
		if(files !=null && files.getSize() > 0) {
			fileService.fileUpload(sess,files,bno);			
		}
		rttr.addFlashAttribute("bno",board.getBno());
		return "redirect:/board/view";
	}
	
	@PostMapping("delete")
	public String delete(int bno, String saveFileName, HttpSession sess) {
		System.out.println(bno);
		System.out.println(saveFileName);
		if(saveFileName != null) {			
			String fileUploadPath = sess.getServletContext().getRealPath("/resources/upload/");
			
			fileService.fileDel(fileUploadPath, saveFileName);
			
			fileService.fileDelete(bno);
			
		}
		
		boardService.deleteBoard(bno);
		
		return "redirect:/board/list";
	}
	
}