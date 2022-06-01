package registration.serviceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import registration.daoImpl.EmployeeDaoImpl;
import registration.model.Department;
import registration.model.Employee;
import registration.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
 
	private EmployeeDaoImpl employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}
	public void insertEmployee(Employee employee) throws ClassNotFoundException{
		employee.setAge(calculateAge(employee));
		employeeDao.registerEmployee(employee);
    }
	private int calculateAge(Employee employee) {
		Date date = employee.getDateOfBirth();
		Instant instant = date.toInstant();
	    ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	    LocalDate givenDate = zone.toLocalDate();
	    //Calculating the difference between given date to current date.
	    Period period = Period.between(givenDate, LocalDate.now());
	    return period.getYears();
	}
	public List<Employee> retrieveEmployee(List<Department>departmentList) throws ClassNotFoundException{
		return employeeDao.employeeList(departmentList);
	}

 
}
