package com.cosmos.dao;

import java.sql.*;
import java.util.*;

import org.springframework.stereotype.*;

import com.cosmos.dto.*;

import oracle.jdbc.*;


@Repository
public class MemberDao {
	final Connection dbconn = OracleConn.getInstance().dbconn();
	
	//회원등록
	public int insertMember(Member m) {
		
		//PreparedStatement stmt = null; 
		int rs =0;
		/*
		String sql ="insert into member(id,pw,name,gender,email,post,addr1,addr2,addr3,intro)";
			   sql +=" values(?,?,?,?,?,?,?,?,?,?)";
		*/
		//방법1
		CallableStatement stmt = null;
		String sql = "{call p_insertMember (?,?,?,?,?,?,?,?,?,?)}";
						
		try {
			//stmt=dbconn.prepareStatement(sql);
			stmt=dbconn.prepareCall(sql);
			stmt.setString(1, m.getId());
			stmt.setString(2, m.getPw());
			stmt.setString(3, m.getName());
			stmt.setString(4, m.getGender());
			stmt.setString(5, m.getEmail());
			stmt.setString(6, m.getPost());
			stmt.setString(7, m.getAddr1());
			stmt.setString(8, m.getAddr2());
			stmt.setString(9, m.getAddr3());
			stmt.setString(10, m.getIntro());
			rs = stmt.executeUpdate();
			
			if(rs>0 && m.getHobby() !=null) {
				// 취미 저장
				/*
				sql = "insert into hobby(hobby_no,member_id,code_val)";
				sql += " values(hobby_no.nextval, ?, ?)";
				*/
				//방법2
				sql = "BEGIN p_addHobby(?,?); END;";
				//stmt = dbconn.prepareStatement(sql);
				stmt= dbconn.prepareCall(sql);
				stmt.setString(1, m.getId());
				
				for(int i=0; i<m.getHobby().length; i++) {
					stmt.setString(2, m.getHobby()[i]);	
					stmt.executeUpdate();
				}
							
				
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int updateMember(Member m) {
		//PreparedStatement stmt =null;
		CallableStatement stmt =null;
		int rs =0;
		//String sql ="update member set name = ?, email =?, gender=?, ";
		//	   sql+=" post=?, addr1=?, addr2=?, addr3=?, intro=? where id = ? ";
		String sql ="{call p_updateMember (?,?,?,?,?,?,?,?,?)}";
		try {
			//stmt=dbconn.prepareStatement(sql);
			stmt=dbconn.prepareCall(sql);
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getEmail());
			stmt.setString(3, m.getGender());
			stmt.setString(4, m.getPost());
			stmt.setString(5, m.getAddr1());
			stmt.setString(6, m.getAddr2());
			stmt.setString(7, m.getAddr3());
			stmt.setString(8, m.getIntro());			
			stmt.setString(9, m.getId());
			rs = stmt.executeUpdate();
			System.out.println(rs);
			if(rs>0  && m.getHobby() !=null) {
				//sql ="delete from hobby where member_id =?";
				sql ="{call p_deleteHobby (?)}";
				//stmt=dbconn.prepareStatement(sql);
				stmt=dbconn.prepareCall(sql);
				stmt.setString(1, m.getId());
				stmt.executeUpdate();
				
				//sql = "insert into hobby(hobby_no,member_id,code_val)";
				//sql += " values(hobby_no.nextval, ?, ?)";
				sql = "BEGIN p_addHobby(?,?); END;";
				//stmt = dbconn.prepareStatement(sql);
				stmt=dbconn.prepareCall(sql);
				stmt.setString(1, m.getId());
				
				for(int i=0; i<m.getHobby().length; i++) {
					if(m.getHobby()[i]!=null) {
						stmt.setString(2, m.getHobby()[i]);	
						stmt.executeUpdate();
					}else {
						break;	
					}
				}
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
			
		return rs;
	}
	
	public int deleteMember(String id) {
		PreparedStatement stmt =null;
		int rs =0;		
		try {
			String sql ="delete from hobby where member_id =?";
			stmt=dbconn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			sql = "update member set isdel='Y' where id =?";
		
			stmt=dbconn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return rs;
		
	}

	public Member[] getMemberList() {
		PreparedStatement stmt = null;
		PreparedStatement stmt2 =null;
		ResultSet rs =null;
		ResultSet rs2 =null;
		String sql ="select * from member m, hobby h";
		       sql += " where m.id =h.member_id(+) order by m.id";
		Member[] mArr = new Member[100];
		String a = null;
		try {
			stmt=dbconn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
											   ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery();

			//레코드 개수 파악
//			rs.last();
//			int rows =rs.getRow();
			
			//커서를 제일 앞으로(rs.first() 보다 한칸 앞 빈공간)
//			rs.beforeFirst();
			
			int i = 0;
						
			while(rs.next()) {
				Member m = new Member();
				mArr[i++] =m;
				String id = rs.getString("id");
				m.setId(id);
				m.setName(rs.getString("name"));
				m.setPw(rs.getString("pw"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				
				if(rs.getString("hobby_no") !=null) {
					String [] hobby = new String[10];
					int j = 0;
					do {					
						hobby[j++] = rs.getString("code_val");
						
						rs.next();
						
						//마지막행인지 검사필요
						//System.out.println("현재행 :" + rs.getRow());
						if(rs.getRow()==0) {
							break;
						}						
						//System.out.println(id);
						//System.out.println(rs.getString("id"));
					}while(id.equals(rs.getString("id")));
					m.setHobby(hobby);
					rs.previous();
					
				}
				
				
								
//				String sql2 ="select code_val from hobby where member_id = ? order by hobby_no";
//				stmt2=dbconn.prepareStatement(sql2);
//				stmt2.setString(1, rs.getString("id"));
//				rs2 = stmt2.executeQuery();
//				int k = 0;
//				while(rs2.next()) {
//					hobby[k++] = rs2.getInt("code_val");
//				}
				
//				for(int j=0; j<hobby.length; j++) {
//					if(rs2.next()) {
//						hobby[j] = rs2.getInt("code_val");
//					}
//				}
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return mArr;
		
	}
	
	//로그인
	public Map<String, String> loginProc(Member member) {
		//PreparedStatement stmt = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
			
		Map<String, String> map = new HashMap<String,String>();
		//String sql = "select pw,name from member where id =?";
		String sql = "{call p_loginMember(?,?)}";
		try {
			//stmt=dbconn.prepareStatement(sql);
			stmt=dbconn.prepareCall(sql);
			stmt.setString(1, member.getId());
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			//rs=stmt.executeQuery();
			stmt.executeQuery();
			
			rs =(ResultSet)stmt.getObject(2);
			
			if(rs.next()) {
				if(member.getPw().equals(rs.getString("pw"))) {
					map.put("stat", "0");
					map.put("name", rs.getString("name"));
										
				}else {
					map.put("stat", "1");
				}
			}else {
				map.put("stat", "2");
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return map;
	}


	public Member getMember(String id) {
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		 String sql = "select * from member m, hobby h where m.id =h.member_id(+) and id = ?";
		 Member m = new Member();
		 
		 try {
			stmt=dbconn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			rs.next();
			String iid = rs.getString("id");
			m.setId(iid);
			m.setName(rs.getString("name"));
			m.setPw(rs.getString("pw"));
			m.setGender(rs.getString("gender"));
			m.setEmail(rs.getString("email"));			
			m.setPost(rs.getString("post"));
			m.setAddr1(rs.getString("addr1"));
			m.setAddr2(rs.getString("addr2"));
			m.setAddr3(rs.getString("addr3"));
			m.setIntro(rs.getString("intro"));
			if(rs.getString("hobby_no") !=null) {
				String [] hobby = new String[10];
				int j = 0;
				do {					
					hobby[j++] = rs.getString("code_val");
					
					rs.next();
								
											
				}while(rs.next());
				m.setHobby(hobby);				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	public int idDoubleCheck(String id) {
	      //PreparedStatement stmt = null;
	      CallableStatement stmt = null;
	      ResultSet rs = null;
	      int stat = 0;
	      
	      //String sql = "select count(*) as cnt from member where ID=?";
//	      boolean rn;
	      String sql = "{call p_idDoubleCheck(?,?)}";
	      try {
	    	  
	         //stmt = dbconn.prepareStatement(sql);
	    	 stmt =dbconn.prepareCall(sql);
	         stmt.setString(1, id);
	         stmt.registerOutParameter(2, OracleTypes.INTEGER);
	         stmt.executeQuery();

	         //rs = stmt.executeQuery();
	         //rs.next();
	         //stat = rs.getInt("cnt");
	         
	         stat =stmt.getInt(2);

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return stat;
	   }
	
}
