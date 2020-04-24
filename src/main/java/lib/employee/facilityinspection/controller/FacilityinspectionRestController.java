package lib.employee.facilityinspection.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDTO;
import lib.employee.facilityinspection.model.FacilitiesInspectionDAO;
import lib.employee.facilityinspection.model.FacilitiesInspectionDTO;
import lib.employee.facilityinspection.model.FacinVO;


@RestController
@RequestMapping(value="/facilityinspection")
@CrossOrigin("*")
public class FacilityinspectionRestController {
	@Autowired
	FacilitiesInspectionDAO dao;
@RequestMapping(value = "/readData",method = RequestMethod.GET,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)

public HashMap check() {
	
	
	List list=dao.facinselect();
	
	
	// 占�??占쏙옙占�? 怨좎튌 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙. 
	HashMap total=new HashMap();
	HashMap data=new HashMap();
	HashMap pagenation=new HashMap();
	pagenation.put("page",1);
	pagenation.put("totalCount",dao.facintotalcount());
	data.put("contents",list);
	
	
	data.put("pagination",pagenation);
	total.put("result", true);
	total.put("data", data);
	
	return total;
}


@RequestMapping(value="/createData",method = RequestMethod.POST ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public HashMap insert(@RequestBody List<FacinVO> dto) {
	 System.out.println(dto.size());
	 
	 for (FacinVO facinVO : dto) {
		 dao.facininsertprocedure(facinVO);
		 System.out.println(facinVO.toString());
	 }	 
	 return check();
}
	
@RequestMapping(value="/modifyData",method = RequestMethod.PUT,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public HashMap facupdate(@RequestBody List<FacilitiesInspectionDTO> dto) {
		System.out.println("?占쏙옙?占쏙옙");
		for (FacilitiesInspectionDTO FacilitiesInspectionDTO : dto) {
		dao.facinupdateprocedure(FacilitiesInspectionDTO);
		}	
	
			return check();
			
}

@RequestMapping(value = "/deleteData",method = RequestMethod.DELETE,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public void facdelete(@RequestBody List<FacilitiesInspectionDTO> dto) {	
	for (FacilitiesInspectionDTO FacilitiesInspectionDTO : dto) {
	
		dao.facindelete(FacilitiesInspectionDTO);
	// ?占쏙옙?占쏙옙?占쏙옙寃껊뱾 ?占쏙옙占�?.
	
	}
	
}
	
}
