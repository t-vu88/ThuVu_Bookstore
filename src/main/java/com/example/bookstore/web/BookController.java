package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.model.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository; 
	
	
	@RequestMapping(value ="/index")
	public String indexPage() {
		
		
		return "index";
	}
}

