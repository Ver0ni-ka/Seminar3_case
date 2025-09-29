package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.PostType;
import model.users.*;

public class MainService {

	private static ArrayList<User> allUsers = new ArrayList<User>();
	public static void main(String[] args) {
		User u1 = new User(); //Guest users
		User u2 = new User(); //Guest users
		PrivateUser u3 = new PrivateUser("s23kofavero", "Abc12345", "Veronika", "Kofanova");
		BusinessUser u4 = new BusinessUser("my.microsoft", "1234poiu??", "Microsoft");
		
		allUsers.addAll(Arrays.asList(u1, u2, u3, u4));
		
		for(User tempU: allUsers) {
			System.out.println(tempU.getClass().getName() + "->" + tempU);
		}

		try {
			u3.createPost(PostType.privatePost, "I want home");
			u3.createPost(PostType.publicPost, "help");
			
			System.out.println(u3.getPrivatePosts());
			System.out.println(u3.getPublicPosts());
			
			u4.createPage("Microsoft in Ventspils", "Info about microsoft in ventspils");
			u4.createPost(PostType.publicPost, "Hello in my page ", "Microsoft in Ventspils");
			u4.createPost(PostType.publicPost, "Discount for Ventspils users", "Microsoft in Ventspils");

			System.out.println("Ventspils page: " + u4.getPages().get(0).getPosts());
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}

}
