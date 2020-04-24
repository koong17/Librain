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
		int endrownum=Perpage*page;

		return sqlsession.getMapper(FacilitiesDAO.class).facSelect(startrownum,endrownum);
	}

	@Override
	public void facinsert(FacilitiesDTO dto) {
		sqlsession.getMapper(FacilitiesDAO.class).facinsert(dto);
	}

	@Override
	public int factotalcount() {
		
		return sqlsession.getMapper(FacilitiesDAO.class).factotalcount();
	}

	@Override
	public void facupdate(FacilitiesDTO dto) {
		sqlsession.getMapper(FacilitiesDAO.class).facupdate(dto);
	}

	@Override
	public void facdelete(FacilitiesDTO facserialnumb) {
		sqlsession.getMapper(FacilitiesDAO.class).facdelete(facserialnumb);
	}

	@Override
	public List<FacilitiesDTO> facRepareSelect(int Perpage,int page) {
		int startrownum=Perpage*page-Perpage;
		int endrownum=Perpage*page;
		return sqlsession.getMapper(FacilitiesDAO.class).facRepareSelect(startrownum,endrownum);
		}

	@Override
	public void facupdaterepair(FacilitiesDTO dto) {
		sqlsession.getMapper(FacilitiesDAO.class).facupdaterepair(dto);
	}

	@Override
	public void facupdaterepaircomplete(FacilitiesDTO dto) {
		sqlsession.getMapper(FacilitiesDAO.class).facupdaterepaircomplete(dto);		
	}

}
