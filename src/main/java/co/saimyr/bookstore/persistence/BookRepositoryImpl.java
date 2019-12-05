package co.saimyr.bookstore.persistence;

import java.util.List;

import co.saimyr.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.crud.CrudBookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private CrudBookRepository h2BookRepo;

	@Override
	public List<Book> findAll() {
		return (List<Book>) h2BookRepo.findAll();
	}
	
	@Override
	public List<Book> findByAuthor(String author) {
		return h2BookRepo.findByAuthor(author);
	}

	@Override
	public Book save(Book b) {
		return h2BookRepo.save(b);
	}
}
