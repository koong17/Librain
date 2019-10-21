package lib.employee.login.model;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lib.employee.management.model.EmployeeDTO;

@Repository
public class LoginDAO {

	@Autowired
	SqlSession sqlSession;
	
	//로그인 체크
	public boolean loginCheck(EmployeeDTO dto) {
		System.out.println("==>loginCheck() 실행");
		String result = sqlSession.selectOne("employeeLoginMapper.loginCheck", dto);
		
		return (Integer.parseInt(result)==0)? false:true;
	}
	
	public String selectSessionName(String emp_no) {
		String result = sqlSession.selectOne("employeeLoginMapper.selectSessionName", emp_no);
		return result;
	}
	
	public String selectSessionAuth(String emp_no) {
		String result = sqlSession.selectOne("employeeLoginMapper.selectSessionAuth", emp_no);
		return result;
	}
	
	public void logout(HttpSession session) {
		System.out.println("==>로그아웃 기능 실행");
		session.invalidate();
	}
}
