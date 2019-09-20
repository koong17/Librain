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
	public List<FacilitiesDTO> facSelect(int Perpage,int page) {
		int startrownum=Perpage*page-Perpage;
		System.out.println(startrownum+"여기는 스타트넘");
		int endrownum=Perpage*page;
		System.out.println(endrownum+"여기는 엔드넘");

		System.out.println("여기찍냐");
		return sqlsession.getMapper(FacilitiesDAO.class).facSelect(startrownum,endrownum);
	}

	@Override
	public void facinsert(FacilitiesDTO dto) {
		sqlsession.getMapper(FacilitiesDAO.class).facinsert(dto);
	}

}
