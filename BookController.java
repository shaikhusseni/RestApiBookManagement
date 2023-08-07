package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;
@RestController



@RequestMapping("api/books")
public class BookController {
	
	@Autowired
	private  BookService bookService;
	
	
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@PostMapping("/sent")
	
	//////////check once  
	public ResponseEntity<Book> createBook(@RequestBody  Book book){
		
		Book savedBook=bookService.createBook(book);
		
		////not clear
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
		
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id)
	{
		Book book=bookService.getBookById(id);
		return new ResponseEntity<>(book,HttpStatus.OK);

		
	}
	
	
	
	
	
	@GetMapping("/get")
	public ResponseEntity<List<Book>>getAllBooks()
	{
		
		List<Book> bookList=bookService.getAllBooks();
		
			return new ResponseEntity<>(bookList,HttpStatus.OK);

	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id")Integer id,@RequestBody Book book)
	{
		book.setId(id);
		Book updatedBook=bookService.updateBook(book);
		return  new ResponseEntity<>(updatedBook,HttpStatus.OK);

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id")Integer id)
	{
		bookService.deleteBook(id);
		return new ResponseEntity<>("Book Was deleted Sucessfully",HttpStatus.OK);
	}
}