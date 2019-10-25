package lib.employee.facilityinspection.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class FacilitiesInspectionDAOImp implements FacilitiesInspectionDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<FacilitiesInspectionDTO> facinselect() {
		// TODO Auto-generated method stub9
		return sqlsession.getMapper(FacilitiesInspectionDAO.class).facinselect();
	}

	@Override
	public int facintotalcount() {
		return sqlsession.getMapper(FacilitiesInspectionDAO.class).facintotalcount();
	}

	@Override
	public void facininsertprocedure(FacinVO vo) {
		sqlsession.getMapper(FacilitiesInspectionDAO.class).facininsertprocedure(vo);
		
	}

	@Override
	public void facinupdateprocedure(FacilitiesInspectionDTO dto) {
		sqlsession.getMapper(FacilitiesInspectionDAO.class).facinupdateprocedure(dto);
		
	}

	@Override
	public void facindelete(FacilitiesInspectionDTO dto) {
		// TODO Auto-generated method stub
		
	}


	

}
