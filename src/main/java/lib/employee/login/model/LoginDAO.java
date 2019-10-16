package lib.employee.login.model;

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
		String name = sqlSession.selectOne("employeeLoginMapper.loginCheck", dto);
		
		return (Integer.parseInt(name)==0)? false:true;
	}
	
	public void logout(HttpSession session) {
		System.out.println("==>로그아웃 기능 실행");
		session.invalidate();
	}
}
