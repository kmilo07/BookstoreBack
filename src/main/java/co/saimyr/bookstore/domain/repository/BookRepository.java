package co.saimyr.bookstore.domain.repository;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.persistence.entity.BookEntity;

public interface BookRepository {
	List<BookstoreDTO> findAll();
	Optional<List<BookstoreDTO>> findByNoun(String author);
	Optional<List<BookstoreDTO>> findByPublisher(String publisher);
	BookstoreDTO save(BookstoreDTO b);


	void deleteById(Integer id);
}
