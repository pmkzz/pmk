package com.cosmos.dao;

import java.sql.*;

import org.springframework.stereotype.*;

import com.cosmos.dto.*;

@Repository
public class FileDao {
	
	final Connection dbconn = OracleConn.getInstance().dbconn();
	
	public int deletFile(int bno) {
		
		int rs = 0;
		
	 	String sql = "Delete FROM fileup WHERE board_no = ?";
	 	PreparedStatement stmt;
		try {
			stmt = dbconn.prepareStatement(sql);
			stmt.setInt(1, bno);
			rs = stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	 		 	
	 	return rs; 		 	
	}

	public void insertFile(UploadFile uploadFile) {
		 int rs=0;
		 
		 String sql = "insert into fileup(file_no,filename,savefilename,"
		 		+ "                       filesize,filetype,filepath,board_no)"
		 		+ "        values(file_no.nextval,?,?,?,?,?,?)";
		 PreparedStatement stmt;
			try {
				stmt = dbconn.prepareStatement(sql);
				stmt.setString(1, uploadFile.getFileName());
				stmt.setString(2, uploadFile.getSaveFileName());
				stmt.setString(3, uploadFile.getFileSize());
				stmt.setString(4, uploadFile.getFileType());
				stmt.setString(5, uploadFile.getFilePath());
				stmt.setString(6, uploadFile.getBoardNo());
				
				rs = stmt.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		 	
		
	}
	
}
