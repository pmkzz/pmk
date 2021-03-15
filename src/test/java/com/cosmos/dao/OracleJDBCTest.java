package com.cosmos.dao;

import java.sql.*;

import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OracleJDBCTest {
	
	private static final Logger log = LoggerFactory.getLogger(OracleJDBCTest.class);
	
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			 
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConntetion() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.53:1521:pmk",
														  "pmk",
														  "0000");
			
			log.info(conn.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
