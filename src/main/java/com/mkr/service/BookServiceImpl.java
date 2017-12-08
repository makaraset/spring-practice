package com.mkr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkr.model.Book;
import com.mkr.repository.BookRepositoryImpl;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepositoryImpl bookRepo;
	
	@Override
	public List<Book> findAll() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book findById(int id) {
		
		return bookRepo.findById(id);
	}

	@Override
	public void addBook(Book book) {
		if(bookRepo.addBook(book)) {
			System.out.println("Book has been added successfully!");
		}else {
			System.out.println("Book failed to add!");
		}
		
	}

	@Override
	public void removeBook(Book book) {
		if(bookRepo.removeBook(book)) {
			System.out.println("Book has been removed successfully!");
		}else {
			System.out.println("Book failed to remove!");
		}
	}

	@Override
	public void updateBook(Book book) {
		if(bookRepo.updateBook(book)) {
			System.out.println("Book has been update successfully!");
		}else {
			System.out.println("Book failed to update!");
		}
		
	}

}
