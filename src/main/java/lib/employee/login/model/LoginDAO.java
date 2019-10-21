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
	public EmployeeDTO loginInfo(EmployeeDTO dto) {
		System.out.println("==>loginInfo() 실행");
		
		return sqlSession.selectOne("employeeLoginMapper.loginInfo", dto);
	}
	
	public void logout(HttpSession session) {
		System.out.println("==>로그아웃 기능 실행");
		session.invalidate();
	}
}
