package co.saimyr.bookstore.persistence;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
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
	public List<BookstoreDTO> findAll() {
		List<BookEntity> bookEntities = (List<BookEntity>) h2BookRepo.findAll();
		return bookstoreMapper.toBookstoresDTO((bookEntities);
	}
	
	@Override
	public Optional<List<BookstoreDTO>> findByNoun(String author) {
		Optional<List<BookEntity>> bookEntities = ;
		return h2BookRepo.findByAuthor(author) h2BookRepo.findByAuthor(author);
	}

	@Override
	public Optional<List<BookEntity>> findByPublisher(String publisher) {
		Optional<List<>>
		return h2BookRepo.findByPublisher(publisher);
	}

	@Override
	public BookEntity save(BookstoreDTO b) {
		return h2BookRepo.save(b);
	}

	@Override
	public void deleteById(Integer id) {
		h2BookRepo.deleteById(id);
	}
}
