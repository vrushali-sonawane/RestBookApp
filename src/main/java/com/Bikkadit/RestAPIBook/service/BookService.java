package com.Bikkadit.RestAPIBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Bikkadit.RestAPIBook.model.Book;
import com.Bikkadit.RestAPIBook.repository.BookRepository;
@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//private static List<Book> list=new ArrayList();
	
//	static {
//		list.add(new Book(101,"Advance java","xyz"));
//		list.add(new Book(102,"Basics of Java","abc"));
//		list.add(new Book(103,"Python Book", "LMN"));
//	}
	
	//get All Books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) bookRepository.findAll();
		return list;
	}
	
	//get single Book by id
	public Book getBookById(int id) {
		Book book=null; 
		try {
			Optional<Book> b = bookRepository.findById(id);
			book = b.stream().filter(e->e.getId()==id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 return book;	 
	}
	// add Book 
	public Book addBook(Book book) {
		Book save = bookRepository.save(book);
		//list.add(book);
		return save;
		
	}
	
	//detete Book by id
	
	public void deleteBook(int bid) {
		//list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		bookRepository.deleteById(bid);
	}
	
	//update book by id
	public void updateBook(Book book, int bid) {
		/*
		 * list=list.stream().map(b->{ if(b.getId()==bid) { b.setTitle(book.getTitle());
		 * b.setAuthor(book.getAuthor()); } return b; }).collect(Collectors.toList());
		 */
		book.setId(bid);
		Book save = bookRepository.save(book);
	}
	
	
}
