package registration.dao;

import java.util.List;

import registration.model.Department;

public interface DepartmentDao {

	public List<Department> departmentIDList() throws ClassNotFoundException;
}
