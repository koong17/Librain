package lib.employee.facility.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/librain-servlet.xml", 
		"file:src/main/webapp/WEB-INF/spring/mybatis.xml"})
@WebAppConfiguration
public class HomeTest {


	 private static final Logger logger = (Logger) LoggerFactory.getLogger(HomeTest.class);

	    @Autowired // Dependency Injection(������ ����)
	    private WebApplicationContext wac;
	    private MockMvc mock;
	    @Autowired
	    private FacilitiesDAO dao;

	    private ObjectMapper mapper;
	    
	    @org.junit.Before
	    public void beforeTest(){
	        logger.info("===== beforeTest() =====");
	        mock = MockMvcBuilders.webAppContextSetup(wac).build();
	        logger.info("wac: " + wac);
	        logger.info("mock: " + mock);
	    }
	
	  @Test 
	 public void doTest(){ 
		 logger.info("===== doTest() =====");
	  
		 RequestBuilder req = MockMvcRequestBuilders.get("/facility/readData").param("perPage", "7").param("page", "1"); 
	  try { 
		mock.perform(req).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	  logger.info("���� ����");
	  } 
	  catch (Exception e) { 
		  logger.error("���� ����: " +e.getMessage()); 
		  } 
	  }
//	  @Test 
//		 public void doTestupdate() throws JSONException, JsonProcessingException{ 
//			 logger.info("===== doTest() =====");
//			 JSONArray arr=new JSONArray();
//			 FacilitiesDTO dto=new FacilitiesDTO();
//			dto.setFac_serialnum(1);
//			dto.setFac_category("����");
//			arr.put(dto);
//			mapper=new ObjectMapper();
//			
//			System.out.println(arr.toString());
//			
//			System.out.println(arr.toString());
//		  RequestBuilder req = MockMvcRequestBuilders.put("/facility/modifyDataRepair").contentType(MediaType.APPLICATION_JSON_UTF8
//				  ).content(mapper.writeValueAsString(dto)); 
//		  try { 
//			mock.perform(req).andDo(print());
//		  logger.info("���� ����");
//		  } 
//		  catch (Exception e) { 
//			  logger.error("���� ����: " +e.getMessage()); 
//			  } 
//		  }
	  
//	  @Test 
//		 public void doTestindex(){ 
//			 logger.info("===== doTest() =====");
//		  RequestBuilder req = MockMvcRequestBuilders.get("/facilityapproval"); 
//		  try { 
//			mock.perform(req).andDo(print());
//		  logger.info("���� ����");
//		  } 
//		  catch (Exception e) { 
//			  logger.error("���� ����: " +e.getMessage()); 
//			  } 
//		  }
//	    @Test
//	    public void doTestA(){ 
//			 logger.info("===== doTest() =====");
//		  RequestBuilder req = MockMvcRequestBuilders.put("/facility/modifyData"); 
//		  try { 
//			mock.perform(req).andDo(print());
//		  logger.info("���� ����");
//		  } 
//		  catch (Exception e) { 
//			  logger.error("���� ����: " +e.getMessage()); 
//			  } 
		 // }
//	    @Test
//	    public void facrepairslect() {
//	    	
//	    	List<FacilitiesDTO> list=new ArrayList<FacilitiesDTO>();
//	    		list=	dao.facRepareSelect(7, 1);
//	    		System.out.println(list.get(0));
//	    }
//	    @Test
//	    public void facrepairupdate() {
//	    	FacilitiesDTO dto=new FacilitiesDTO();
//	    	dto.setFac_serialnum(222);
//	    dao.facupdaterepair(dto);
//	    }

//@Autowired
//Home home;
//	 @Test
//	 public void TestC() {
//		 Home home=new Home();
//		 Assert.assertEquals("test", home.testC());
//	 }

	    @org.junit.After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
}
