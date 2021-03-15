package com.cosmos.service;


import javax.servlet.http.*;

import org.apache.commons.fileupload.*;
import org.springframework.web.multipart.*;

import com.cosmos.dto.*;



public interface FileService {
	
	public void fileUpload(HttpSession sess, MultipartFile files, int bno);
	
	public void fileDown(HttpServletRequest request, HttpServletResponse response);
	
	public void fileDel(String uploadPath, String saveFileName);
	
	public int fileDelete(int bno);
}
