package com.thanhduyen.springmybatis.report;

import java.util.*;

import com.thanhduyen.springmybatis.dao.EmployeeMapper;
import com.thanhduyen.springmybatis.entity.Employee;

public class EmployeeReport {

	public List<Map<String, ?>> getAllEmployees() {
		List<Map<String, ?>> listEmployee = new ArrayList<Map<String, ?>>();
		EmployeeMapper mapper = new EmployeeMapper();
		for (Employee e : mapper.getAllEmployees()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", e.getId());
			m.put("fullname", e.getFullname());
			m.put("email", e.getEmail());
			m.put("gender", e.getGender());
			m.put("hobbies", e.getHobbies());
			m.put("country", e.getCountry());
			m.put("address", e.getAddress());
			listEmployee.add(m);
		}
		return listEmployee;
	}

}
