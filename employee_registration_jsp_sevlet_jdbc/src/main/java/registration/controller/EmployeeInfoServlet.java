package registration.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.model.Employee;
import registration.serviceImpl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeInfoServlet
 */
@WebServlet("/employeeInfo")
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeServiceImpl employeeService;
	private List<Employee> employeeList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//    public EmployeeInfoServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	public void init() {
		employeeService = new EmployeeServiceImpl();
		employeeList = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			employeeList = employeeService.retrieveEmployee(EmployeeRegistrationServlet.departmentList);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("empList", employeeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
		dispatcher.forward(request, response);
	}

}
