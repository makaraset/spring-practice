package com.mkr.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	private int id;
	
	@NotEmpty(message = "Title cannot be empty!")
	@Size(min = 10, max = 50, message = "Title must be between {2} and {1} characters!")
	private String title;
	
	@NotEmpty(message="Publish date cannot be empty!")
	private String publishDate;
	
	@NotEmpty(message = "Author cannot be empty!")
	@Size(min = 10, max = 30, message = "Author must be between {2} and {1} characters!")
	private String author;
	
	@Min(100)
	@Max(3000)
	private int page;
	
	private String coverImage;
	
	public Book(int id, String title, String publishDate, String author, int page, String coverImage) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.page = page;
		this.coverImage = coverImage;
	}
	
	public Book(){
		
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", author=" + author + ", page="
				+ page + ", coverImage=" + coverImage + "]";
	}

	
}
