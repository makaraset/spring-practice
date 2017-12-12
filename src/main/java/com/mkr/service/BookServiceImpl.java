package com.mkr.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.mkr.model.Book;
import com.mkr.repository.MybaticBookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private MybaticBookRepository bookRepo;

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
		if (bookRepo.addBook(book)) {
			System.out.println("Book has been added successfully!");
		} else {
			System.out.println("Book failed to add!");
		}

	}

	@Override
	public void removeBook(Book book) {
		if (bookRepo.removeBook(book)) {
			System.out.println("Book has been removed successfully!");
		} else {
			System.out.println("Book failed to remove!");
		}
	}

	@Override
	public void updateBook(Book book) {
		if (bookRepo.updateBook(book)) {
			System.out.println("Book has been update successfully!");
		} else {
			System.out.println("Book failed to update!");
		}

	}

	@Override
	public void initBook() {
//		System.out.println(bookRepo.findAll().size());
		final Faker faker = new Faker();
		if (bookRepo.findAll().size() < 1) {
			for (int i = 0; i < 10; i++) {
				String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				Book book = new Book(i + 1, faker.book().title(), dateStr, faker.book().author(), 1000,
						faker.internet().image(50, 50, false, null));
//				System.out.println(book);
				bookRepo.addBook(book);
			}
		}

	}

}
