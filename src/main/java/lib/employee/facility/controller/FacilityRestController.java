package lib.employee.facility.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;


@RestController
@RequestMapping(value="/facility")
@CrossOrigin("*")
public class FacilityRestController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping(value = "/readData",method = RequestMethod.GET,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public HashMap check(@RequestParam int perPage,@RequestParam int page ) {
	
	
	List list=facilitiesDAO.facSelect(perPage,page);
	
	
	// 占�??占쏙옙占�? 怨좎튌 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙. 
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
@RequestMapping(value = "/readDataRepair",method = RequestMethod.GET,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public HashMap repareselect(@RequestParam int perPage,@RequestParam int page ) {
	
	
	List list=facilitiesDAO.facRepareSelect(perPage,page);
	
	
	// 占�??占쏙옙占�? 怨좎튌 ?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙. 
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



@RequestMapping(value="/createData",method = RequestMethod.POST,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public void insert(@RequestBody List<FacilitiesDTO> dto) {
	System.out.println("?占쏙옙?占쏙옙");
	for (FacilitiesDTO facilitiesDTO : dto) {
	facilitiesDAO.facinsert(facilitiesDTO);
	}
}
	
@RequestMapping(value="/modifyData",method = RequestMethod.PUT ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public void facupdate(@RequestBody List<FacilitiesDTO> dto) {
		System.out.println("?占쏙옙?占쏙옙");
		for (FacilitiesDTO facilitiesDTO : dto) {
		//facilitiesDAO.facinsert(facilitiesDTO);
		System.out.println(facilitiesDTO.toString());
		facilitiesDAO.facupdate(facilitiesDTO);
		}	
	
			
}

@RequestMapping(value="/modifyDataRepair",method = RequestMethod.PUT,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public void facupdaterepair(@RequestBody FacilitiesDTO dto) {
	
	
	if(dto.getFac_status().equals("접수완료")) { //占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙曼占쏙옙占�.
		facilitiesDAO.facupdaterepaircomplete(dto);
	}else {
		facilitiesDAO.facupdaterepair(dto);
	}
		
}



@RequestMapping(value = "/deleteData",method = RequestMethod.DELETE,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public void facdelete(@RequestBody List<FacilitiesDTO> dto) {	
	for (FacilitiesDTO facilitiesDTO : dto) {
	
		facilitiesDAO.facdelete(facilitiesDTO);
	// ?占쏙옙?占쏙옙?占쏙옙寃껊뱾 ?占쏙옙占�?.
	
	}
	
}
	
}
