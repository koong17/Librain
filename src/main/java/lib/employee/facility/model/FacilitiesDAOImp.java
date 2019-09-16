package lib.employee.facility.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacilitiesDAOImp implements FacilitiesDAO {
	
	@Autowired
	SqlSession sqlsession;
	
	@Override
	public List<FacilitiesDTO> facSelect() {
		System.out.println("확인");
		System.out.println("여기는2222"+sqlsession.selectList("facSelect222").get(0));
		
		return sqlsession.getMapper(FacilitiesDAO.class).facSelect();
	}

}
