package lib.employee.facility.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.Param;

import lib.employee.facility.model.FacilitiesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/librain-servlet.xml", 
		"file:src/main/webapp/WEB-INF/spring/mybatis.xml"})
@WebAppConfiguration
public class HomeTest2 {

	 private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeTest2.class);

	    @Autowired // Dependency Injection(������ ����)
	    private WebApplicationContext wac;
	    private MockMvc mock;
	    @Autowired
	   FacilitiesDAO dao;
	    
	    @Before
	    public void beforeTest(){
	        logger.info("===== beforeTest() =====");
	        mock = MockMvcBuilders.webAppContextSetup(wac).build();
	        logger.info("wac: " + wac);
	        logger.info("mock: " + mock);
	    }
	

	    @Test
	 public void testFacDAO() {
	    	System.out.println("doTest!!!");
	    	//System.out.println(dao.facSelect(7, 1));
	    	System.out.println(dao.factotalcount());
	    }

	    @After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
}
	