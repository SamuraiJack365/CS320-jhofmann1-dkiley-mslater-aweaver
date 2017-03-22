package edu.ycp.cs320.booksdb.model;

public class Author {
	private int authorId;
	private String lastname;
	private String firstname;
	
	public Author() {
		
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getFirstname() {
		return firstname;
	}
}
