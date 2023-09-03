package com.pial.book_club_organizer.service;

import com.pial.book_club_organizer.exception.BookAlreadyExistsException;
import com.pial.book_club_organizer.exception.BookNotFoundException;
import com.pial.book_club_organizer.model.Book;
import com.pial.book_club_organizer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found!"));
    }

    public void addBook(Book book) throws BookAlreadyExistsException {
        if (bookRepository.existsByTitle(book.getTitle())) {
            throw new BookAlreadyExistsException("Book already exists!");
        }
        bookRepository.save(book);
    }

    public void updateBook(Book book) throws BookNotFoundException {
        if (!bookRepository.existsById(book.getId())) {
            throw new BookNotFoundException("Book not found!");
        }
        bookRepository.saveAndFlush(book);
    }


    public void deleteBookById(Integer id) throws BookNotFoundException {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found!");
        }
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitleContainingOrAuthorContainingOrGenreContaining(String query, String query1, String query2) {
        return bookRepository.findByTitleContainingOrAuthorContainingOrGenreContaining(query,query1,query2);
    }
}
