package registration.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.model.Department;
import registration.model.Employee;
import registration.serviceImpl.DepartmentServiceImpl;
import registration.serviceImpl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeSevlet
 */
@WebServlet("/register")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeServiceImpl employeeService;
	private DepartmentServiceImpl departmentService;
	static List<Department> departmentList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		employeeService = new EmployeeServiceImpl();
		departmentService = new DepartmentServiceImpl();
		departmentList =  null;
    }
	
//    public EmployeeSevlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			departmentList = departmentService.retrieveDepartment();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("listDepartment", departmentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        float salary = Float.parseFloat(request.getParameter("salary"));
        

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(request.getParameter("dateOfBirth"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int departmentID = Integer.parseInt(request.getParameter("department"));
        Department department = departmentList.get(departmentID-1);
        
        Employee employee = new Employee(firstName, lastName, email, phone, salary, dateOfBirth, department);

        try {
        	employeeService.insertEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("SelectedDepartmentID", departmentID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
	}

}
