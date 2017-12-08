package com.mkr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mkr.model.Book;
import com.mkr.service.BookService;
import com.mkr.service.FileUploadService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private FileUploadService fileService;
	
	@RequestMapping(value = {"/","index", "/home", "/book"})
	public String getBooks(Model model) {
		List<Book> books = bookService.findAll(); 
		model.addAttribute("books", books);
		return "index";
	}
	
	@RequestMapping("/book/detail/{id}")
	private String getBookbyId(Model model,@PathVariable(name="id") int id ) {
		Book book = bookService.findById(id);
		model.addAttribute("book", book);
		
		return "bookdetail";
	}
	
	@GetMapping("/book/add")
	private String boAddBook(Model model) {
		model.addAttribute("actionstat", true);
		model.addAttribute("book", new Book());
		return "book";
	}
	
	@GetMapping("/book/edit/")
	private String boEditBook(Model model, @RequestParam("id") int id) {
		model.addAttribute("actionstat", false);
		model.addAttribute("book", bookService.findById(id));
		return "book";
	}
	
	@PostMapping("/book/add")
	private String addBook(Model model , @RequestParam("file") MultipartFile file, @Valid Book book, BindingResult result) {
		if(result.hasErrors()) {
			for(FieldError error: result.getFieldErrors()){
				System.out.println(error.getField() +": "+ error.getDefaultMessage());
			}
			model.addAttribute("actionstat", true);
			model.addAttribute("book", book);
			return "/book";
		}
		
		String filePath = fileService.upload(file); 
		book.setCoverImage(filePath);
		bookService.addBook(book);
		
		return "redirect:/";
	}
	
	@PostMapping("/book/edit")
	private String updateBook(@RequestParam("file") MultipartFile file,@Valid Book book, Model model, BindingResult result) {
		
		if(result.hasErrors()) {
			for(FieldError error: result.getFieldErrors()){
				System.out.println(error.getField() +": "+ error.getDefaultMessage());
			}
			model.addAttribute("actionstat", false);
			model.addAttribute("book", book);
			return "/book";
			
		}
		
		if(!file.isEmpty()){
			System.out.println("file: " + file.getOriginalFilename());
			String filePath = fileService.upload(file);
			book.setCoverImage(filePath);
			
		}
		
		bookService.updateBook(book);
		return "redirect:/";
	}
	
	@PostMapping("/book/remove")
	private String removeBook(@RequestParam("id") int id) {
		bookService.removeBook(bookService.findById(id));
		return "redirect:/";
	}
	
}
