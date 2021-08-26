package co.saimyr.bookstore.domain.repository;

import java.util.List;

import co.saimyr.bookstore.domain.BookstoreDomain;
import co.saimyr.bookstore.domain.dto.BookstoreDTO;

public interface BookRepository {
	List<BookstoreDomain> findAll();
	List<BookstoreDomain> findByNoun(String author);
	List<BookstoreDomain> findByPublisher(String publisher);
	BookstoreDomain save(BookstoreDomain bookstoreDomain);
	void delete(Integer id);
	BookstoreDomain getBook(int id);
}
