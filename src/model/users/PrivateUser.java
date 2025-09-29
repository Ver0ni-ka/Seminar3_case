package model.users;

import java.util.ArrayList;

import model.Post;
import model.PostType;

public class PrivateUser extends RegisteredUser {

	private String name;
	private String surname;
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<RegisteredUser> followers = new ArrayList<RegisteredUser>();

	
	
	public String getName() {
		return name;
	}



	public String getSurname() {
		return surname;
	}



	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}



	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}



	public ArrayList<RegisteredUser> getFollowers() {
		return followers;
	}


	public void setName(String inputName) {
		if(inputName != null  && inputName.matches("[A-Z]{1}[a-z]{3,15}")) {
			name = inputName;
		} else {
			name = "No name";
		}
	}
	public void setSurname(String inputSurname) {
		if(inputSurname != null  && inputSurname.matches("[A-Z]{1}[a-z]{3,15}")) {
			surname = inputSurname;
		} else {
			surname = "No surname";
		}
	}
	
	public void addPrivatePost(Post post) {
		if(post != null) {
			privatePosts.add(post);
		} else {
			privatePosts.add(new Post());
		}
	}
	
	public void addPublicPost(Post post) {
		if(post != null) {
			publicPosts.add(post);
		} else {
			publicPosts.add(new Post());
		}
	}

	
	public PrivateUser() {
		super();
		setName("Private");
		setSurname("User");
	}
	
	public PrivateUser(String inputUsername, String inputPassword, String inputName, String inputSurname) {
		super(inputUsername, inputPassword);
		setName(inputName);
		setSurname(inputSurname);
	}
	
	public String toString() {
		return super.toString() + " " + name + " " + surname;
	}
	
	//[0] - text message for the post
	@Override
	public void createPost(PostType posttype, String... params) throws Exception{
		if(posttype == null || params == null) {
			throw new Exception("Params should be not null");
		} 
		if(params.length < 1) {
			throw new Exception("There is no message in input param");
		}
		
		Post newPost = new Post(params[0]);
		if(posttype.equals(PostType.privatePost)) {
			privatePosts.add(newPost);
		} else if(posttype.equals(PostType.publicPost)) {
			publicPosts.add(newPost);
		}
		
	}
	
	
	
	
	

}
