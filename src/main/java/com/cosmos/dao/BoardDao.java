package com.cosmos.dao;


import java.sql.*;

import java.util.*;

import org.springframework.stereotype.*;

import com.cosmos.dto.*;

import oracle.jdbc.*;

@Repository
public class BoardDao {
	final Connection dbconn = OracleConn.getInstance().dbconn();
	
	public ArrayList<Board> getBoardList(){
		
		CallableStatement stmt = null;
		
		String sql = "{call p_getBoardList(?)}";
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			rs = (ResultSet)stmt.getObject(1);
			
			while(rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("board_no"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setCnt(rs.getInt("cnt"));
				b.setOpen(rs.getString("isopen"));
				b.setWdate(rs.getString("wdate"));
				b.setId(rs.getString("member_id"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return list;
	}

	public int insertBoard(Board board) {
		 CallableStatement stmt=null;
		 String sql ="{call p_insertBoard(?,?,?,?)}";
		 int rs = 0;
		 try {
			stmt=dbconn.prepareCall(sql);
			stmt.setString(1,board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setString(3, board.getId());
			stmt.registerOutParameter(4, OracleTypes.INTEGER);
			stmt.executeUpdate();
			
			rs =stmt.getInt(4);
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
				 
		return rs;
	}

	public Board getBoard(int bno) {

		CallableStatement stmt = null;
		ResultSet rsBoard = null;
		ResultSet rsFile = null;
//		int exist = 0;
		
		Board b = new Board();

		String sql = "{call p_getBoard(?,?,?,?)}";
		
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.setInt(1, bno);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.registerOutParameter(3, OracleTypes.CURSOR);
			stmt.registerOutParameter(4, OracleTypes.INTEGER);
			stmt.executeQuery();
			
			rsBoard = (ResultSet)stmt.getObject(2);
			rsFile = (ResultSet)stmt.getObject(3);
//			exist= stmt.getInt(4);
//			System.out.println(exist);
			while(rsBoard.next()) {
				b.setBno(rsBoard.getInt("board_no"));
				b.setTitle(rsBoard.getString("title"));
				b.setContent(rsBoard.getString("content"));
				b.setCnt(rsBoard.getInt("cnt"));
				b.setOpen(rsBoard.getString("isopen"));
				b.setWdate(rsBoard.getString("wdate"));
				b.setId(rsBoard.getString("member_id"));
				
				if(rsFile.next()) {
					UploadFile f = new UploadFile();
					f.setFileNo(rsFile.getString("file_no"));
					f.setFileName(rsFile.getString("filename"));
					f.setFilePath(rsFile.getString("filepath"));
					f.setFileSize(rsFile.getString("filesize"));
					f.setFileType(rsFile.getString("filetype"));
					f.setSaveFileName(rsFile.getString("savefilename"));
					
					b.setUpfile(f);
				}
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return b; 
		
	}

	public void updateBoard(Board board) {
		 CallableStatement stmt =null;
		 
		 String sql = "{call p_updateBoard(?,?,?)}";
		 
		 try {
			stmt=dbconn.prepareCall(sql);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setInt(3, board.getBno());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

	public int deleteBoard(int bno) {
		CallableStatement stmt =null;
		 
		 String sql = "{call p_deleteBoard(?)}";
		 int rs = 0; 
		 
			try {
				stmt=dbconn.prepareCall(sql);
				stmt.setInt(1, bno);
				rs = stmt.executeUpdate();
				
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
			
		 
		return rs;
	}

	public ArrayList<Notice> getNoticeList() {
		
		CallableStatement stmt = null;
		
		String sql = "{call p_getNoticeList(?)}";
		ResultSet rs = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			rs = (ResultSet)stmt.getObject(1);
			
			while(rs.next()) {
				Notice n = new Notice();
				n.setNno(rs.getInt("notice_no"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setCnt(rs.getInt("cnt"));
				n.setId(rs.getString("member_id"));
				n.setWdate(rs.getString("wdate"));
				n.setOdate(rs.getString("odate"));
				
				
				list.add(n);
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return list;
	}

	public Notice getNotice(int nno) {
		CallableStatement stmt = null;
		ResultSet rsNotice = null;	
				
		Notice n = new Notice();

		String sql = "{call p_getNotice(?,?)}";
		
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.setInt(1, nno);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			rsNotice = (ResultSet)stmt.getObject(2);
			
			while(rsNotice.next()) {
				n.setNno(rsNotice.getInt("notice_no"));
				n.setTitle(rsNotice.getString("title"));
				n.setContent(rsNotice.getString("content"));
				n.setCnt(rsNotice.getInt("cnt"));
				n.setId(rsNotice.getString("member_id"));				
				n.setWdate(rsNotice.getString("wdate"));
				n.setOdate(rsNotice.getString("odate"));
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return n;	 
	
	}

	public ArrayList<Tboard> getTboardList() {
		CallableStatement stmt = null;
		
		String sql = "{call p_getTBoardList(?)}";
		ResultSet rs = null;
		ArrayList<Tboard> list = new ArrayList<Tboard>();
		
		try {	
			stmt = dbconn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			rs = (ResultSet)stmt.getObject(1);
			
			while(rs.next()) {
				Tboard t  = new Tboard();
				t.setTno(rs.getInt("tboard_no"));
				t.setTitle(rs.getString("title"));
				t.setContent(rs.getString("content"));
				t.setId(rs.getString("member_id"));
				t.setPnum(rs.getInt("pnum"));
				t.setCnt(rs.getInt("cnt"));
				t.setPtime(rs.getString("ptime"));
				t.setAtime(rs.getString("atime"));
				t.setWdate(rs.getString("wdate"));
				t.setIsdel(rs.getString("isdel"));
				
				list.add(t);
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return list;
	}

	public Tboard getTboard(int tno) {
		CallableStatement stmt = null;
		ResultSet rsTboard = null;	
				
		Tboard t = new Tboard();

		String sql = "{call p_getTboard(?,?)}";
		
		
		try {
			stmt = dbconn.prepareCall(sql);
			stmt.setInt(1, tno);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			rsTboard = (ResultSet)stmt.getObject(2);
			
			while(rsTboard.next()) {
				t.setTno(rsTboard.getInt("tboard_no"));
				t.setTitle(rsTboard.getString("title"));
				t.setContent(rsTboard.getString("content"));
				t.setId(rsTboard.getString("member_id"));
				t.setPnum(rsTboard.getInt("pnum"));
				t.setCnt(rsTboard.getInt("cnt"));
				t.setPtime(rsTboard.getString("ptime"));
				t.setAtime(rsTboard.getString("atime"));
				t.setWdate(rsTboard.getString("wdate"));
				t.setIsdel(rsTboard.getString("isdel"));
			}
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return t;	 
	
	}

	public int insertTboard(Tboard t) {
		CallableStatement stmt =null;
		int rs = 0;
		
		String sql = "{call p_inserttboard(?,?,?,?,?,?,?)}";
		try {
			stmt = dbconn.prepareCall(sql);
			
			stmt.setString(1, t.getId());
			stmt.setString(2, t.getTitle());
			stmt.setString(3, t.getContent());
			stmt.setInt(4, t.getPnum());
			stmt.setString(5, t.getAtime());
			stmt.setString(6, t.getPtime());
			stmt.registerOutParameter(7, OracleTypes.INTEGER);
			stmt.executeUpdate();
			
			rs =stmt.getInt(7);	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}


}
