package model.users;

public class User {
	protected int id;
	private static int counter = 0;
	
	public int getId() {
		return id;
	}
	public void setId() {
		id = counter;
		counter++;
	}
	
	public User() {
		setId();
	}
	
	public String toString() {
		return id + "";//We added one value of class string so return THE string
	}
	
	
}
