package co.saimyr.bookstore.domain.repository;

import java.util.List;

import co.saimyr.bookstore.domain.Book;

public interface BookRepository {
	public List<Book> findAll();
	public List<Book> findByAuthor(String author);
	public Book save(Book b);
}
