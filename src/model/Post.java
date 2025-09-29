package model;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

	private String msg;
	private LocalDateTime datetime;
	private int countOfLikes;
	
	public String getMsg() {
		return msg;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public void setMsg(String inputMsg) {
			if(inputMsg != null && inputMsg.matches("[A-Za-z0-9 .,/!@#$%^&*()]{1,160}")) {
				msg = inputMsg;
			} else {
				msg = "No message";
			}
		}

	public void setDatetime() {
		datetime = LocalDateTime.now();
	}
	
	public void insreaseLikes() {
		countOfLikes++;
	}
	
	public Post() {
		setMsg("Test massage");
		setDatetime();
		countOfLikes = 0;
	}
	
	public Post(String inputMsg) {
		setMsg(inputMsg);
		setDatetime();
		countOfLikes = 0;
	}
	
	public String toString(){
		return msg + " |" + countOfLikes + "❤️, " + datetime.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + 
	datetime.getHour() + ":" + datetime.getMinute() + ":" + datetime.getSecond() + "|";
	}
	



}
