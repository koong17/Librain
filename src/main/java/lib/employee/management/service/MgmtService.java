package lib.employee.management.service;

import org.json.simple.JSONArray;

public interface MgmtService {
	public JSONArray empSelectAll();
	public void delete(JSONArray ja);
}
