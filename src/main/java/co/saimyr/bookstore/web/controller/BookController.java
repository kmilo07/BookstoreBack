package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.saimyr.bookstore.domain.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookstoreDTO>> getAll() {
		return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookstoreDTO>> getByAuthor(@PathVariable("author") String writer) {
		return new ResponseEntity<>(bookService.getAllByAuthor(writer), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookstoreDTO> newBook(@RequestBody BookstoreDTO book) {
		return new ResponseEntity<>(bookService.newBook(book),HttpStatus.CREATED);
	}

	@GetMapping(value = "/publisher/{publisher}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookstoreDTO>> getByPublisher(@PathVariable("publisher") String publisher){
		return new ResponseEntity<>(bookService.findByPublisher(publisher), HttpStatus.OK);
	}

	@GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookstoreDTO> getBook(@PathVariable("id") int id){
		return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id ){
		bookService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

}
