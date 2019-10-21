package lib.employee.facilityinspection.controller;

import java.awt.PageAttributes.MediaType;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;
import lib.employee.facilityinspection.model.FacilitiesInspectionDAO;


@RestController
@RequestMapping(value="/facilityinspection")
@CrossOrigin("*")
public class FacilityinspectionRestController {
	@Autowired
	FacilitiesInspectionDAO dao;
@RequestMapping(value = "/readData",method = RequestMethod.GET)
public HashMap check(@RequestParam int perPage,@RequestParam int page ) {
	
	
	List list=dao.facinselect(perPage,page);
	
	
	// �??���? 고칠 ?��?��?�� ?��?��. 
	HashMap total=new HashMap();
	HashMap data=new HashMap();
	HashMap pagenation=new HashMap();
	pagenation.put("page",page);
//	pagenation.put("totalCount",dao.factotalcount());
	data.put("contents",list);
	
	
	data.put("pagination",pagenation);
	total.put("result", true);
	total.put("data", data);
	
	return total;
}


@RequestMapping(value="/createData",method = RequestMethod.POST )
public void insert(@RequestBody List<FacilitiesDTO> dto) {
	System.out.println("?��?��");
	for (FacilitiesDTO facilitiesDTO : dto) {
	//facilitiesDAO.facinsert(facilitiesDTO);
	}
}
	
@RequestMapping(value="/modifyData",method = RequestMethod.PUT )
	public void facupdate(@RequestBody List<FacilitiesDTO> dto) {
		System.out.println("?��?��");
		for (FacilitiesDTO facilitiesDTO : dto) {
		//facilitiesDAO.facinsert(facilitiesDTO);
		System.out.println(facilitiesDTO.toString());
	//	facilitiesDAO.facupdate(facilitiesDTO);
		}	
	
			
}

@RequestMapping(value = "/deleteData",method = RequestMethod.DELETE)
	public void facdelete(@RequestBody List<FacilitiesDTO> dto) {	
	for (FacilitiesDTO facilitiesDTO : dto) {
	
		//facilitiesDAO.facdelete(facilitiesDTO);
	// ?��?��?��것들 ?���?.
	
	}
	
}
	
}
