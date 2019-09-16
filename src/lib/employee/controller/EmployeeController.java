package lib.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lib.employee.model.FacilitiesDAO;
import lib.employee.model.FacilitiesDTO;

@Controller
public class EmployeeController {

	FacilitiesDAO facilitiesDAO; 
	
@GetMapping
public void check() {
	List<FacilitiesDTO> list=
	facilitiesDAO.facSelect();
	
	
	
}
	
	
}
