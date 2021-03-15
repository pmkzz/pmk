package com.cosmos.service;

import java.io.*;
import java.util.*;


import javax.servlet.http.*;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.*;


import com.cosmos.dao.*;
import com.cosmos.dto.*;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public ArrayList<Board> getBoardList() {

		return boardDao.getBoardList();
	}

	@Override
	public int insertBoard(Board board) {

		return boardDao.insertBoard(board);
	}
		


	@Override
	public void updateBoard(Board board) {
		
		boardDao.updateBoard(board);
				
	}

	@Override
	public int deleteBoard(int bno) {

		return boardDao.deleteBoard(bno);
	}

	@Override
	public Board getBoard(int bno) {

		return boardDao.getBoard(bno);
	}

	@Override
	public Board[] searchBoard(String criteria, String keyword) {

		return null;
	}

}
