package com.pial.book_club_organizer.controller;



import com.pial.book_club_organizer.model.Reader;
import com.pial.book_club_organizer.service.BookService;
import com.pial.book_club_organizer.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reader")
public class ReaderController {

    @Autowired
    private ReaderService readerService;



    @GetMapping("/all")
    public ResponseEntity<List<Reader>> getAllReader() {
        List<Reader> readerList = readerService.getAllReader();
        return new ResponseEntity<>(readerList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reader> getReaderById(@PathVariable Integer id) {
        Optional<Reader> reader = readerService.getReaderById(id);
        return new ResponseEntity<>(reader.get(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addReader(@RequestBody Reader reader) {
        readerService.addReader(reader);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateReader(@RequestBody Reader reader) {
        readerService.updateReader(reader);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReader(@PathVariable Integer id) {
        readerService.deleteReaderById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }





}
