package com.bookexchange.booksmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookexchange.booksmicroservice.model.Book;
import com.bookexchange.booksmicroservice.repository.BookRepository;

@Service
public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksByOwnerid(Long ownerid) {
        return bookRepository.findByOwnerid(ownerid);
    }

    public Book addBook(Book book) {
        logger.info("Received Book: {}", book);
        if (book.getOwnerid() == null || book.getOwnerid() == 0) {
            logger.error("Invalid ownerId: {}", book.getOwnerid());
            throw new IllegalArgumentException("Owner ID cannot be null or zero");
        }
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setOwnerid(updatedBook.getOwnerid());
            return bookRepository.save(book);
        });
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
