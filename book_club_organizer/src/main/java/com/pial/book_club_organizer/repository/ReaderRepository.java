package com.pial.book_club_organizer.repository;

import com.pial.book_club_organizer.model.Book;
import com.pial.book_club_organizer.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {

}
