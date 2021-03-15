package com.cosmos.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.cosmos.dao.*;
import com.cosmos.dto.*;

@Service
public class TboardServiceImpl implements TboardService {
	
	@Autowired
	BoardDao dao;
	@Override
	public ArrayList<Tboard> getTboardList() {
		 
		return dao.getTboardList();
	}
	@Override
	public Tboard getTboard(int tno) {
		 
		return dao.getTboard(tno);
	}	
	@Override
	public int insertTboard(Tboard t) {		 
		return dao.insertTboard(t);
	}

}
