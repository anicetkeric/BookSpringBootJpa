package com.spring.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.spring.book.entities.Book;
import com.spring.book.repository.BookRepository;



@RestController
@RequestMapping("/bookRest")
public class BookController {

	 @Autowired
	 private BookRepository bookRepository;
	

	 @RequestMapping(value="/create", method=RequestMethod.POST)
	 public Book create(@RequestBody Book book) {		
	     try {
	    	 book = bookRepository.save(book);
	       }
	       catch (Exception ex) {
	         return null;
	       }
	     return book;
	 }
	 
	 
	 @RequestMapping(value="/getOne", method=RequestMethod.GET)	
	 public Book read(@RequestParam int id) {
		 Book book = bookRepository.findOne(id);
	     
	     if(book==null) return null;
		return book;
	 }
	 
}
