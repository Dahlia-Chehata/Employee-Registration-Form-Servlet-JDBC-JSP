package registration.service;

import java.util.List;

import registration.model.Department;

public interface DepartmentService {

	public List<Department> retrieveDepartment() throws ClassNotFoundException;

}
