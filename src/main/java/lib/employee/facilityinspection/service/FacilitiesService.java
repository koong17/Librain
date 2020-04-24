package lib.employee.facilityinspection.service;

import java.util.List;

import lib.employee.facility.model.FacilitiesDTO;

public interface FacilitiesService {
	public List<FacilitiesDTO> facselect(int Perpage,int page);
}
