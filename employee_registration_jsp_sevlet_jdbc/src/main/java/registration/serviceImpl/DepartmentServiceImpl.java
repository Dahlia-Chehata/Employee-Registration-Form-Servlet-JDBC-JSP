package registration.serviceImpl;

import java.util.List;

import registration.dao.DepartmentDao;
import registration.daoImpl.DepartmentDaoImpl;
import registration.model.Department;
import registration.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{

   private DepartmentDao departmentDao;
   
   public DepartmentServiceImpl () {
	   departmentDao = new DepartmentDaoImpl();
   }
   
   public List<Department> retrieveDepartment() throws ClassNotFoundException{
	   return departmentDao.departmentIDList();
   }

}
