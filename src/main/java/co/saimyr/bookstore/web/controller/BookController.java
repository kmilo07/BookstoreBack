package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.domain.exception.BookException;
import co.saimyr.bookstore.domain.exception.ResourceNotFoundException;
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

	@GetMapping(value = "/book/{isbnId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<BookstoreDTO> getBook(@PathVariable("isbnId") int isbnId){
		BookstoreDTO bookData = bookService.getBook(isbnId);
		if(bookData != null){
			return new ResponseEntity<>(bookData,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{isbnId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("isbnId") int isbnId ){
		BookstoreDTO bookData = bookService.getBook(isbnId);
		if(bookData != null){
			bookService.delete(isbnId);
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		else{
			String message = "No se ha encontrado el libro";
			BookException bookException = new BookException();
			ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(message);
			bookException.resourceNotFoundException(resourceNotFoundException);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
