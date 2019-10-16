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
	
	//
	public ArrayList<EmployeeDTO> selectSessionInfo(EmployeeDTO dto){
		System.out.println("유저 정보 불러오기");
		System.out.println("LoginDAO 실행" + sqlSession.selectOne("employeeLoginMapper.selectSessionInfo", dto));
		ArrayList<EmployeeDTO> list = new ArrayList<>();
		list.add(dto);
		return list;//여기까지 ok
	}
	
	public void logout(HttpSession session) {
		System.out.println("==>로그아웃 기능 실행");
		session.invalidate();
	}
}
