package com.mkr.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.mkr.model.Book;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> books = new ArrayList<>();
	
	private Faker faker = new Faker();
	
	public BookRepositoryImpl() {
		
		for(int i = 0 ; i<10; i++) {
			
			String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

			books.add(new Book(i+1, faker.book().title(), dateStr , faker.book().author(), 1000, faker.internet().image(50, 50, false, null)));
		}
		
	}
	@Override
	public List<Book> findAll() {
		return books;
	}

	@Override
	public Book findById(int id) {
		return books.get(id-1);
	}
	@Override
	public boolean addBook(Book book) {
		
		return books.add(book);
	}
	@Override
	public boolean removeBook(Book book) {
		
		return books.remove(book);
	}
	@Override
	public boolean updateBook(Book book) {
		
		for(int i=0;i< books.size(); i++) {
			if (book.getId()==books.get(i).getId()) {
				books.set(i, book);
				return true;
			}
		}
		
		return false;
	}
	
}
