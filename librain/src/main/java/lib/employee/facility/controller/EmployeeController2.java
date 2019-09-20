package lib.employee.facility.controller;

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
@RequestMapping(value="/facility")
public class EmployeeController2 {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
@RequestMapping(value = "/readData",method = RequestMethod.GET)
public HashMap check(@RequestParam int perPage,@RequestParam int page ) {
	
	
	List list=facilitiesDAO.facSelect(perPage,page);
	
	
	// 변수명 고칠 필요성 높음. 
	HashMap aa=new HashMap();
	HashMap aa2=new HashMap();
	HashMap aa3=new HashMap();
	aa3.put("page",page);
	aa3.put("totalCount",100);
	
	aa2.put("contents",list);
	
	
	aa2.put("pagination",aa3);
	aa.put("result", true);
	aa.put("data", aa2);
	
	return aa;
}


@RequestMapping(value="/createData",method = RequestMethod.POST )
public void insert(@RequestBody List<FacilitiesDTO> dto) {
	System.out.println("확인");
	for (FacilitiesDTO facilitiesDTO : dto) {
	facilitiesDAO.facinsert(facilitiesDTO);
	}
}
	
@RequestMapping(value="/updateData",method = RequestMethod.PUT )
	public void facupdate(@RequestBody List<FacilitiesDTO> dto) {
		System.out.println("확인");
		for (FacilitiesDTO facilitiesDTO : dto) {
		facilitiesDAO.facinsert(facilitiesDTO);
		}	
	
			
}
	
	
}
