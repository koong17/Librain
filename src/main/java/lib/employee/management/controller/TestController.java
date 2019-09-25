//package lib.employee.management.controller;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import lib.employee.management.model.EmployeeDAO;
//
//@Controller
//@Component
//public class TestController {
//	
//	@Autowired
//	private SqlSession sqlsession;
//	
//	@RequestMapping("/hi.do")
//	public String insertTest() {
//		EmployeeDAO empDAO = sqlsession.getMapper(EmployeeDAO.class);
//		empDAO.insertaa();
//		return "test";
//	}
//}
