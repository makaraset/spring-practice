package com.mkr.repository;

import java.util.List;

import com.mkr.model.Book;

public interface BookRepository {
	
	public List<Book> findAll();
	public Book findById(int id);
	
	public boolean addBook(Book book);
	public boolean removeBook(Book book);
	public boolean updateBook(Book book);
	
}
