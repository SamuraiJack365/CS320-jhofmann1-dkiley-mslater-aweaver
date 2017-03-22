package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;

public class InitialData {
	public static List<Author> getAuthors() throws IOException {
		List<Author> authorList = new ArrayList<Author>();
		ReadCSV readAuthors = new ReadCSV("authors.csv");
		try {
			// auto-generated primary key for authors table
			Integer authorId = 1;
			while (true) {
				List<String> tuple = readAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Author author = new Author();
				author.setAuthorId(authorId++);				
				author.setLastname(i.next());
				author.setFirstname(i.next());
				authorList.add(author);
			}
			return authorList;
		} finally {
			readAuthors.close();
		}
	}
	
	public static List<Book> getBooks() throws IOException {
		List<Book> bookList = new ArrayList<Book>();
		ReadCSV readBooks = new ReadCSV("books.csv");
		try {
			// auto-generated primary key for books table
			Integer bookId = 1;
			while (true) {
				List<String> tuple = readBooks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Book book = new Book();
				book.setBookId(bookId++);
				book.setAuthorId(Integer.parseInt(i.next()));
				book.setTitle(i.next());
				book.setIsbn(i.next());
				book.setPublished(Integer.parseInt(i.next()));
				bookList.add(book);
			}
			return bookList;
		} finally {
			readBooks.close();
		}
	}
}
