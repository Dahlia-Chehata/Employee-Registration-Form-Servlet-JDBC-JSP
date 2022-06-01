package registration.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import registration.dao.EmployeeDao;
import registration.model.Department;
import registration.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	public List<Employee> employeeList(List<Department>departmentList) throws ClassNotFoundException {
		List<Employee> employeeList = new ArrayList<Employee>();
         
		try (Connection connection = StaticConnection.initConnection();) {
	     String sql = "SELECT * FROM MegaClass.Employee";
         Statement statement = connection.createStatement();
         ResultSet result = statement.executeQuery(sql);
             
         while (result.next()) {
        	 int ID = result.getInt("ID");
        	 String firstName = result.getString("FirstName");
        	 String lastName = result.getString("LastName");
        	 String email = result.getString("Email");
        	 String phone = result.getString("Phone");
        	 float salary = result.getFloat("Salary");
        	 int age = result.getInt("Age");
        	 int departmentID = result.getInt("DepartmentID");
        	 
            Employee employee = new Employee(ID, firstName, lastName, email, phone, salary, age, departmentList.get(departmentID-1));         
            employeeList.add(employee);
         }          
    	 connection.close();
        } catch (SQLException e) {
        	StaticConnection.printSQLException(e);
		}   
        return employeeList;
      }
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_EMPLOYEES_SQL = "INSERT INTO MegaClass.Employee" +
            " (FirstName, LastName, Age, Email, Phone, Salary, DepartmentID)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?);";

        int result = 0;

     
        try (Connection connection = StaticConnection.initConnection();
            
        	// Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            
        	//preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setFloat(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getDepartment().getID());

            System.out.println(preparedStatement);
            
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // process sql exception
            StaticConnection.printSQLException(e);
        }
        return result;
    }

}
