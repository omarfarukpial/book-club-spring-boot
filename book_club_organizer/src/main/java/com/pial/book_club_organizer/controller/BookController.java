package com.pial.book_club_organizer.controller;

import com.pial.book_club_organizer.model.Book;
import com.pial.book_club_organizer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
       Optional<Book> book = bookService.getBookById(id);
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
