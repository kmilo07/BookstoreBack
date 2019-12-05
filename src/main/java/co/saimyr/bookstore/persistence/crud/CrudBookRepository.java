package co.saimyr.bookstore.persistence.crud;

import java.util.List;

import co.saimyr.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface CrudBookRepository extends CrudRepository<Book, Integer> {
	public List<Book> findByAuthor(String author);
}
