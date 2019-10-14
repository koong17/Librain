package lib.employee.facilityinspection.controller;

import java.awt.PageAttributes.MediaType;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


@RestController
@RequestMapping(value="/facilityinspection")
public class FacilityinspectionRestController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping(value = "/readData",method = RequestMethod.GET)
public HashMap check(@RequestParam int perPage,@RequestParam int page ) {
	
	
	List list=facilitiesDAO.facSelect(perPage,page);
	
	
	// Î≥??àòÎ™? Í≥†Ïπ† ?ïÑ?öî?Ñ± ?Üí?ùå. 
	HashMap total=new HashMap();
	HashMap data=new HashMap();
	HashMap pagenation=new HashMap();
	pagenation.put("page",page);
	pagenation.put("totalCount",facilitiesDAO.factotalcount());
	data.put("contents",list);
	
	
	data.put("pagination",pagenation);
	total.put("result", true);
	total.put("data", data);
	
	return total;
}


@RequestMapping(value="/createData",method = RequestMethod.POST )
public void insert(@RequestBody List<FacilitiesDTO> dto) {
	System.out.println("?ôï?ù∏");
	for (FacilitiesDTO facilitiesDTO : dto) {
	facilitiesDAO.facinsert(facilitiesDTO);
	}
}
	
@RequestMapping(value="/modifyData",method = RequestMethod.PUT )
	public void facupdate(@RequestBody List<FacilitiesDTO> dto) {
		System.out.println("?ôï?ù∏");
		for (FacilitiesDTO facilitiesDTO : dto) {
		//facilitiesDAO.facinsert(facilitiesDTO);
		System.out.println(facilitiesDTO.toString());
		facilitiesDAO.facupdate(facilitiesDTO);
		}	
	
			
}

@RequestMapping(value = "/deleteData",method = RequestMethod.DELETE)
	public void facdelete(@RequestBody List<FacilitiesDTO> dto) {	
	for (FacilitiesDTO facilitiesDTO : dto) {
	
		facilitiesDAO.facdelete(facilitiesDTO);
	// ?ï¥?ïº?ï†Í≤ÉÎì§ ?†ïÎ¶?.
	
	}
	
}
	
}
