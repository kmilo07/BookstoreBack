package co.saimyr.bookstore.web.controller;

import java.util.List;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import co.saimyr.bookstore.domain.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookstoreDTO> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookstoreDTO> getByAuthor(@PathVariable("author") String writer) {
		return bookService.getAllByAuthor(writer);
	}
	
	@PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BookstoreDTO newBook(@RequestBody BookstoreDTO book) {
		return bookService.newBook(book);
	}
	@GetMapping(value = "/publisher/{publisher}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<BookstoreDTO> getByPublisher(@PathVariable("publisher") String publisher){
		return bookService.findByPublisher(publisher);
	}

	@GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BookstoreDTO getBook(@PathVariable("id") int id){
		return bookService.getBook(id);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public void deleteBook(@PathVariable("id") int id ){
		bookService.delete(id);
	}

}
