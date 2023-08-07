package com.example.demo.Entity;

//import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	
	@Id
	private int id;
	private String title;
	private String author;
	private String content;
	public Book(int id, String title, String author, String content) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	public Book()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + "]";
	}
	
//	public void setId(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	

}
