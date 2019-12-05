package co.saimyr.bookstore.domain.service;

import java.util.List;

import co.saimyr.bookstore.domain.Book;
import co.saimyr.bookstore.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	public List<Book> getAllByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}
	public Book newBook(Book b) {
		return bookRepository.save(b);
	}
}