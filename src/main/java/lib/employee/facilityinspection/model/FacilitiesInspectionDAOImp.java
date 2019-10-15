package lib.employee.facilityinspection.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lib.employee.facility.model.FacilitiesDAO;

@Repository
public class FacilitiesInspectionDAOImp implements FacilitiesInspectionDAO {
	
	@Autowired
	SqlSession sqlsession;

	@Override
	public List<FacilitiesDTO> facSelect(int startrownum, int endrownum) {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(FacilitiesInspectionDAO.class).facSelect(startrownum, endrownum);
	}
	
	

}
