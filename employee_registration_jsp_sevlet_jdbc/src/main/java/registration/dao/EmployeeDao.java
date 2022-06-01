package registration.dao;

import java.util.List;

import registration.model.Department;
import registration.model.Employee;

public interface EmployeeDao {
	
	public List<Employee> employeeList(List<Department>departmentList) throws ClassNotFoundException;

	public int registerEmployee(Employee employee) throws ClassNotFoundException;
}
