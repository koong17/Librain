package lib.employee.model;

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

		return sqlsession.getMapper(FacilitiesDAO.class).facSelect();
	}

}
