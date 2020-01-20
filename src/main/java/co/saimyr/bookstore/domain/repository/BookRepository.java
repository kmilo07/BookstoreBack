package co.saimyr.bookstore.domain.repository;

import java.util.List;

import co.saimyr.bookstore.domain.Book;

public interface BookRepository {
	List<Book> findAll();
	List<Book> findByAuthor(String author);
	List<Book> findByPublisher(String publisher);
	Book save(Book b);
	Book delete(Book b);
}
