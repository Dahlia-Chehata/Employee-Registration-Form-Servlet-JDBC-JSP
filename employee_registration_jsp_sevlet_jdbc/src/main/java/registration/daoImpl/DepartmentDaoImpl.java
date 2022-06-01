package registration.daoImpl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import registration.dao.DepartmentDao;
import registration.model.Department;

public class DepartmentDaoImpl implements DepartmentDao{
	
	public List<Department> departmentIDList() throws ClassNotFoundException {
		List<Department> departmentList = new ArrayList<Department>();
         
		try (Connection connection = StaticConnection.initConnection();) {
	     String sql = "SELECT * FROM MegaClass.Department";
         Statement statement = connection.createStatement();
         ResultSet result = statement.executeQuery(sql);
             
         while (result.next()) {
            int id = result.getInt("ID");
            String name = result.getString("Name");
            Department department = new Department(id, name);         
            departmentList.add(department);
         }          
    	 connection.close();
        } catch (SQLException e) {
        	StaticConnection.printSQLException(e);
		}   
        return departmentList;
      }
 }
