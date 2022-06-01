package registration.model;

public class Department {
	private int ID;
	private String name;
	
	public Department() {
		
	}
	public Department(int ID, String Name) {
		this.ID = ID;
		this.name = Name;
	}
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
