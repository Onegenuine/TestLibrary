package ru.falaleev.tesproject.TestLibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.falaleev.tesproject.TestLibrary.models.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);
    List<Book> findByTitleStartingWith(String title);

}
