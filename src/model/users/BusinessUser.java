package model.users;

import java.util.ArrayList;

import model.PostType;
import model.Page;
import model.Post;


public class BusinessUser extends RegisteredUser {

	private String businessName;
	private ArrayList<Page> pages = new ArrayList<Page>();
	
	public String getBusinessName() {
		return businessName;
	}



	public ArrayList<Page> getPages() {
		return pages;
	}

	
	public void setBusinessName(String inputName) {
		if(inputName != null && inputName.matches("[A-Z]{1}[a-z]{2,20}")) {
			businessName = inputName;
		} else {
			businessName = "No business name";		
			}
	}
	
	public BusinessUser() {
		super();
		setBusinessName("Test");
	}
	
	public BusinessUser(String inputUsername, String inputPassword, String inputname) {
		super(inputUsername, inputPassword);
		setBusinessName(inputname);
	}


	
	public String toString() {
		return businessName + "";
	}



	@Override
	public void createPost(PostType posttype, String... params) throws Exception {
		if(posttype == null || params == null) {
			throw new Exception("Params should be not null");
		} 
		if(params.length < 2) {
			throw new Exception("There is no message and page in input param");
		}
		
		Post newPost = new Post(params[0]);
		for(Page tempP : pages) {
			for(int i = 1; i < params.length; i++) {
				if(tempP.getTitle().equals(params[i])) {
					tempP.getPosts().add(newPost);
				}
			}
		}
		
		
	}
	
	public void createPage(String inputTitle, String inputD) throws Exception{
		if(inputTitle == null || inputD == null) {
			throw new Exception("Params should be not null");
		}
		for(Page tempP: pages) {
			if(tempP.getTitle().equals(inputTitle)) {
				throw new Exception("This title already exist");

			}
		}
		Page newPage = new Page(inputTitle, inputD);
		pages.add(newPage);
	}
	
}
