package co.saimyr.bookstore.domain.service;

import java.util.List;
import java.util.Optional;

import co.saimyr.bookstore.domain.dto.BookstoreDTO;
import co.saimyr.bookstore.domain.repository.BookRepository;
import co.saimyr.bookstore.persistence.entity.BookEntity;
import co.saimyr.bookstore.persistence.mapper.BookstoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<BookstoreDTO> getAll() {
		return bookRepository.findAll();
	}
	public Optional<List<BookstoreDTO>> getAllByAuthor(String author) {
		return bookRepository.findByNoun(author);
	}
	public BookstoreDTO newBook(BookstoreDTO b) {
		return bookRepository.save(b);
	}
	public List<BookstoreDTO> findByPublisher(String publisher){
		return bookRepository.findByPublisher(publisher);
	}

	public void delete(Integer id){
		bookRepository.deleteById(id);
	}
}
