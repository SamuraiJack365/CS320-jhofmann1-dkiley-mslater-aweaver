package edu.ycp.cs320.booksdb.model;

public class Book {
	private int    bookId;
	private int    authorId;
	private String title;
	private String isbn;
	private int    published;
	
	public Book() {
		
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public int getAuthorId() {
		return authorId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setPublished(int published) {
		this.published = published;
	}
	
	public int getPublished() {
		return published;
	}
}
