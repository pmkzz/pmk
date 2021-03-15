package com.cosmos.service;

import java.util.*;

import com.cosmos.dto.*;



public interface TboardService {

	ArrayList<Tboard> getTboardList();

	Tboard getTboard(int tno);

	int insertTboard(Tboard t);

}
