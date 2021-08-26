package co.saimyr.bookstore.persistence.crud;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.persistence.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudBookRepository extends CrudRepository<BookEntity, Integer> {
	List<BookEntity> findAllByOrderByNameAsc();
	List<BookEntity> findByAuthor(String author);
	List<BookEntity> findByPublisher(String publisher);
	BookEntity findByIsbn(Integer id);
	void delete(BookEntity bookEntity);
}
