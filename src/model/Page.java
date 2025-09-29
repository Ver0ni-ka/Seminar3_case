package model;

import java.util.ArrayList;

import model.users.RegisteredUser;

public class Page {
	private String title;
	private String description;
	private ArrayList<RegisteredUser> followers= new ArrayList<RegisteredUser>();
	private ArrayList<Post> posts= new ArrayList<Post>();
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<RegisteredUser> getFollowers() {
		return followers;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setTitle(String inputTitle) {
		if(inputTitle != null && inputTitle.matches("[A-Za-z0-9 ()]{4,40}")) {
			title = inputTitle;
		} else {
			title = "No title";
		}
		
	}
	
	public void setDescription(String descr) {
		if(descr != null && descr.matches("[A-Za-z0-9 ().,:;]{4,300}")) {
			description = descr;
		} else {
			description = "No description";		}}

		
		//No setters for array list because they are initialized already
		
	public Page() {
		setTitle("Test");
		setDescription("Page");
		
	}
	
	public Page(String inputTitle, String inputD) {
		setTitle(inputTitle);
		setDescription(inputD);
		
	}
	
	public String toString() {
		return title + " " + description; 
	}
		
		
		
		
		
		
		
		
		
		
		
		
}
	

