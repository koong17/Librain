package lib.employee.facilityinspection.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lib.employee.facility.model.FacilitiesDAO;
import lib.employee.facility.model.FacilitiesDTO;

@Controller
@CrossOrigin("*")
public class FacilityinspectionController {
	@Autowired
	FacilitiesDAO facilitiesDAO; 
	
	
	@RequestMapping("/facilityinspection")
public String check(Model model) {
	System.out.println("?��?��");
	List<FacilitiesDTO> list=facilitiesDAO.facSelect(1,1);
	model.addAttribute("list",list);
	return "employee/erp/facility/facilityinspection";
	
	
}



}
