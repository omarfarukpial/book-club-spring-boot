package com.pial.book_club_organizer.service;

import com.pial.book_club_organizer.model.Book;
import com.pial.book_club_organizer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.saveAndFlush(book);
    }


    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }

}
