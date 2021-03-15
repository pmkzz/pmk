package com.cosmos.dao;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.*;

import com.cosmos.dto.*;

import oracle.jdbc.*;
@Repository
public class LoginDao {
	
	final Connection dbconn = OracleConn.getInstance().dbconn();
	

	
	public Map<String,String> loginProc(String id, String pw) {
		CallableStatement stmt = null;
		ResultSet rs = null;
		String sql = "{call p_loginMember(?,?)}";
		
		Map<String,String> map = new HashMap<String,String>();
		Login l = new Login();
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.setString(1, id);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			stmt.executeQuery();			
			
			rs =(ResultSet)stmt.getObject(2);						
			if(rs.next()) {
				if(pw.equals(rs.getString("pw"))) {
						map.put("stat", "0");
						map.put("name", rs.getString("name"));
					
										
				}else {
					map.put("stat", "1");
				}
			}else {
				map.put("stat", "2");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		
		return map; 
		
	}


	public int getMemberCnt() {
		 PreparedStatement stmt = null;
		 String sql = "select count(*) cnt from member";
		 ResultSet rs = null;
		 int cnt = 0;
		 try {
			stmt=dbconn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			cnt=rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return cnt;
	}


	public int isdelMemberCnt() {
		 PreparedStatement stmt = null;

         String sql = "select count(*) cnt from member where isdel='Y'";
		 ResultSet rs = null;
		 int isdelCnt = 0;
		 try {
			stmt=dbconn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			isdelCnt=rs.getInt("cnt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isdelCnt;
	}

}
