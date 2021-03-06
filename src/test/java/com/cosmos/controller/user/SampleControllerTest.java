package com.cosmos.controller.user;

import javax.inject.*;

import org.junit.*;
import org.junit.runner.*;
import org.slf4j.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;
import org.springframework.test.context.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class SampleControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc; //브라우저에서 요청과 응답을 의미하는 객체
	
	@Before
	public void setup() {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
			log.info("setup...");
	}
	
	@Test
	public void testDoa() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
