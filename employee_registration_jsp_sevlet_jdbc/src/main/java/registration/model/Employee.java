package registration.model;

import java.util.Date;

public class Employee {
	private int ID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private float salary;
	private Department department;
	private Date dateOfBirth;
	private int age;
	
	public Employee(int ID, String firstName, String lastName, String email, String phone, float salary, int age, Department department) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
		this.department = department;		
	}
	public Employee(String firstName, String lastName, String email, String phone, float salary, Date dateOfBirth, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
		this.department = department;		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}

}
