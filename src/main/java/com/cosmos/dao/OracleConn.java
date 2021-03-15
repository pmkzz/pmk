package com.cosmos.dao;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class OracleConn {
	private static OracleConn oc= new OracleConn();
		
	
	private OracleConn() {
		
	}
	
	public static OracleConn getInstance() {
		return oc;
	}
	
	public Connection dbconn() {
		Properties prop = new Properties();
		String path = OracleConn.class.getResource("pmk.properties").getPath();
		Connection conn = null;

		try {
		path = URLDecoder.decode(path, "utf-8");
		
		prop.load(new FileReader(path));
		
		Class.forName(prop.getProperty("driver"));
		conn = DriverManager.getConnection(prop.getProperty("url"), 
   			 							   prop.getProperty("user"), 
										   prop.getProperty("pw"));
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 jdbc driver 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
