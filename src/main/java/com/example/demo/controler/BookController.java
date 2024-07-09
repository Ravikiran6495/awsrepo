package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enity.Book;
import com.example.demo.serviceImpl.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	BookServiceImpl bookServiceImpl;

	@GetMapping("/book")
	public List<Book> getAllBooks() {
		return bookServiceImpl.getAllBooks();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
		Optional<Book> book = bookServiceImpl.getBookById(id);
		return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		return bookServiceImpl.saveBook(book);
	}

	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		Optional<Book> optionalBook = bookServiceImpl.getBookById(id);

		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			book.setIsbn(bookDetails.getIsbn());
			return ResponseEntity.ok(bookServiceImpl.saveBook(book));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
		if (bookServiceImpl.getBookById(id).isPresent()) {
			bookServiceImpl.deleteBook(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
