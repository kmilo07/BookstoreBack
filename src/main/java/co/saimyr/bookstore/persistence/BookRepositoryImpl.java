package co.saimyr.bookstore.persistence;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.BookstoreDomain;
import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.domain.exception.BookException;
import co.saimyr.bookstore.domain.exception.ResourceNotFoundException;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.persistence.mapper.BookstoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.crud.CrudBookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private CrudBookRepository h2BookRepo;

	@Autowired
	private BookstoreMapper bookstoreMapper;

	@Override
	public List<BookstoreDomain> findAll() {
		return bookstoreMapper.toBookstores(h2BookRepo.findAllByOrderByNameAsc());
	}
	
	@Override
	public List<BookstoreDomain> findByNoun(String author) {
		return bookstoreMapper.toBookstores(h2BookRepo.findByAuthor(author));
	}

	@Override
	public List<BookstoreDomain> findByPublisher(String publisher) {
		return  bookstoreMapper.toBookstores(h2BookRepo.findByPublisher(publisher));
	}

	@Override
	public BookstoreDomain save(BookstoreDomain bookstoreDomain) {
		return bookstoreMapper.toBookstore(h2BookRepo.save(bookstoreMapper.toBookstore(bookstoreDomain)));
	}

	@Override
	public void delete(Integer id) {
		BookstoreDomain bookstoreDomain = bookstoreMapper.toBookstore(h2BookRepo.findByIsbn(id));
		if (bookstoreDomain!=null){
			h2BookRepo.delete(bookstoreMapper.toBookstore(bookstoreDomain));
		}
		else{
			String message = "No se ha encontrado el libro";
			BookException bookException = new BookException();
			ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException(message);
			bookException.resourceNotFoundException(resourceNotFoundException);
		}
	}

	@Override
	public BookstoreDomain getBook(int id) {
		return bookstoreMapper.toBookstore(h2BookRepo.findByIsbn(id));
	}
}
