package registration.service;

import java.util.List;

import registration.model.Department;
import registration.model.Employee;

public interface EmployeeService {
	
	public void insertEmployee(Employee employee) throws ClassNotFoundException;
	public List<Employee> retrieveEmployee(List<Department>departmentList) throws ClassNotFoundException;

}
