package com.cosmos.controller.user;


import java.io.*;

import javax.servlet.http.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.cosmos.service.*;



@Controller
public class FileController{

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private FileService fileService;
	
	@PostMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(String savefilename, String filepath){
		
		Resource resource = new FileSystemResource(filepath + savefilename);
		
		if(resource.exists()==false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		log.info("resource : " + resource);
		String resourceName = resource.getFilename();
		log.info("resourceName : " + resourceName);
		//uuid제거
		resourceName = resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachement; filename ="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {			 
			e.printStackTrace();
		}		
		return new ResponseEntity<>(resource,headers,HttpStatus.OK); 
		
	}
	
	@RequestMapping(value="/deleteFile",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> deleteFile(int bno, String saveFileName, HttpSession sess){
		//파일테이블 레코드 삭제
		System.out.println(bno);
		int rs = fileService.fileDelete(bno);
		
		String out = null;
		if(rs>0) {
			String fileUploadPath = sess.getServletContext().getRealPath("/resources/upload/");
			fileService.fileDel(fileUploadPath, saveFileName);
			out = "1";
		}else {
			out = "0";
		}
		
		return new ResponseEntity<String>(out,HttpStatus.OK);
	}
	
	

}
