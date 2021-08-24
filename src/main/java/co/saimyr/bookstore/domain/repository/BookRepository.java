package co.saimyr.bookstore.domain.repository;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.BookstoreDomain;
import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;

public interface BookRepository {
	List<BookstoreDomain> findAll();
	List<BookstoreDomain> findByNoun(String author);
	List<BookstoreDomain> findByPublisher(String publisher);
	BookstoreDomain save(BookstoreDomain bookstoreDomain);
	void delete(Integer id);
}
