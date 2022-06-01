package registration.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaticConnection {
 
	public static Connection initConnection() throws ClassNotFoundException {
		
		Connection connection = null;
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;database=EmployeeRecords;";
            connection = DriverManager.getConnection(connectionUrl, "ROOT*123", "ROOT*123");
        } catch (SQLException e) {
        	printSQLException(e);
        }
        
        return connection;
	}
//	public static void closeConnection(Connection connection) throws SQLException {
//		connection.close();
//	}
	public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
