package co.saimyr.bookstore.domain.service;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.persistence.mapper.BookstoreMapper;
import co.saimyr.bookstore.persistence.mapper.BookstoreMapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookstoreMapperDTO bookstoreMapper;

	public List<BookstoreDTO> getAll() {
		return bookstoreMapper.toBookstoreDtos(bookRepository.findAll());
	}
	public List<BookstoreDTO> getAllByAuthor(String author) {
		return bookstoreMapper.toBookstoreDtos(bookRepository.findByNoun(author));
	}
	public BookstoreDTO newBook(BookstoreDTO b) {
		return bookstoreMapper.toBookstoreDTO(bookRepository.save(bookstoreMapper.toBookstoreDomain(b)));
	}
	public List<BookstoreDTO> findByPublisher(String publisher){
		return bookstoreMapper.toBookstoreDtos(bookRepository.findByPublisher(publisher));
	}

	public BookstoreDTO getBook(int id){
		return bookstoreMapper.toBookstoreDTO(bookRepository.getBook(id));
	}

	public void delete(Integer id){
		bookRepository.delete(id);
	}
}
