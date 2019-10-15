package lib.employee.facility.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.RegularExpressionValueMatcher;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import test.test2.model.TestDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class JsonTest {

	 private static final Logger logger = (Logger) LoggerFactory.getLogger(JsonTest.class);

	    @Autowired // Dependency Injection(의존성 주입)
	    private WebApplicationContext wac;
	    private MockMvc mock;
	    @Autowired
	    TestDao dao;
	    
	    @Before
	    public void beforeTest(){
	        logger.info("===== beforeTest() =====");
	        mock = MockMvcBuilders.webAppContextSetup(wac).build();
	        logger.info("wac: " + wac);
	        logger.info("mock: " + mock);
	    }
	

	
	@Test
	public void testDoC() throws Exception {

//		mock.perform(MockMvcRequestBuilders.post("/checkpro")).andDo(print());
//		JSONAssert.assert

		JSONObject actual = new JSONObject();
		JSONArray array=new JSONArray();
		actual.put("id", 1);
		actual.put("name", "mkyong");
		actual.put("age", 37);
		array.put(actual);
		
		JSONObject actual2=new JSONObject();
		actual2.put("0", array);
		System.out.println(actual2);
		
		JSONAssert.assertEquals("{id:1}", actual2.getJSONArray("0").getJSONObject(0), false); 					//Pass, extended fields doesn't matter
		JSONAssert.assertEquals("{name:\"mkyong\"}", actual, false);		//Pass
		JSONAssert.assertEquals("{name:\"mkyong\", age:37}", actual, false);//Pass
		JSONAssert.assertEquals("{name:mkyong, id:1}", actual, false);		//Pass
		JSONAssert.assertEquals("{id:1, age:37}", actual, false);			//Pass
		
	}//테스트완료
	
	@Test
	public void jsontestB() throws IllegalArgumentException, JSONException {
		
		 	
		JSONAssert.assertEquals("{entry:{id:x}}", "{entry:{id:1, id:2}}", 
				  (JSONComparator) new CustomComparator(
				  JSONCompareMode.STRICT, 
				  new Customization("entry.id", 
				  new RegularExpressionValueMatcher<Object>("\\d"))));
		
		JSONAssert.assertEquals("{entry:{id:x}}", "{entry:{id:1, id:2}}", 
				  new CustomComparator(
						  JSONCompareMode.STRICT, 
						  new Customization("entry.id", 
						  new RegularExpressionValueMatcher<Object>("\\d"))));
		
	}
	 
	@Test
	public void testDoD() throws Exception {

//		mock.perform(MockMvcRequestBuilders.post("/checkpro")).andDo(print());
//		JSONAssert.assert
System.out.println("testDODDDDDDDDDDDDDDDD");
		JSONObject actual = new JSONObject();
		JSONArray array=new JSONArray();
		actual.put("id", 1);
		actual.put("name", "mkyong");
		actual.put("age", 37);
		array.put(actual);
		array.put(actual);
		JSONObject actual2=new JSONObject();
		actual2.put("0", array);
		System.out.println(array.get(0));
		
		JSONAssert.assertEquals("{id:1}", actual2.getJSONArray("0").getJSONObject(0), false); 					//Pass, extended fields doesn't matter
		
	}//테스트완료
	@Test
	public void dothattestA() throws Exception {
		
mock.perform(MockMvcRequestBuilders.post("ddd")).andExpect(jsonPath("$.", is(3)));		
	}
	    @After
	    public void afterTest(){
	        logger.info("===== afterTest() =====");
	    }
	    
}
	