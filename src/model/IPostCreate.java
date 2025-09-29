package model;

public interface IPostCreate {
	//only public abstract functions are there
	//public abstract void fun();   We can not write first two words
	
	public abstract void createPost(PostType posttype, String ... params) throws Exception;
	
}
