package model.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.IPostCreate;
import model.PostType;
import service.MainService;
import model.Post;

public abstract class RegisteredUser extends User implements IPostCreate{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String inputUsername) {
		if(inputUsername != null && inputUsername.matches("[A-Za-z.]{6,25}")) {
			username = id + "_" + inputUsername;
		} else {
			username = "No.username";
		}
	}
	
	public void setPassword(String inputPassword) {
		if(inputPassword != null && inputPassword.matches("[a-zA-Z0-9.,?]{6,17}")) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				password = new String(md.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				password = "No password";
			}
			
		} else {
			password = "No password";
		}
	}
	
	public RegisteredUser() {
		super();
		setUsername("Test");
		setPassword("Test password");
	}
	
	public RegisteredUser(String inputUsername, String inputPassword) {
		super();
		setUsername(inputUsername);
		setPassword(inputPassword);
	}
	
	public String toString() {
		return super.toString() + ", username: " + username + " password: " + password;
	}
	
	public void followUser(String username) throws Exception{
		if(username == null) {
			throw new Exception("no null");
		}
		
		for(User tempU: MainService.getAllUsers()) {
			RegisteredUser tempRU = (RegisteredUser)tempU;
			if(tempRU.getUsername().equals(username)) {
				if(tempRU instanceof PrivateUser) {
					PrivateUser tempPU = (PrivateUser)tempRU;
					tempPU.getFollowers().add(this);
				}
			}
		}
	}

}
