package com.mkr.service;

import java.util.List;

import com.mkr.model.Book;

public interface BookService {
	
	public List<Book> findAll();
	public Book findById(int id);
	
	public void addBook(Book book);
	public void removeBook(Book book);
	public void updateBook(Book book);
}
