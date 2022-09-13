package hh.swd20.bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private String isbn;
	private int price;
	
	

	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.price = 0;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
