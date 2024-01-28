package ru.falaleev.tesproject.TestLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.falaleev.tesproject.TestLibrary.models.Book;
import ru.falaleev.tesproject.TestLibrary.models.Person;
import ru.falaleev.tesproject.TestLibrary.repositories.BooksRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }


    //поиск всех книг
    public List<Book> findAll() {
        return booksRepository.findAll();
    }


    //поиск одной книги по id
    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }


    //поиск книги по названию
    public List<Book> searchByTitle(String query) {
        return booksRepository.findByTitleStartingWith(query);
    }


    //сохранение книги
    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }


    //удаление книги
    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }


    @Transactional
    public void update(int id, Book updatedBook) {
        Book bookToBeUpdated = booksRepository.findById(id).get();

        updatedBook.setId(id);
        updatedBook.setOwner(bookToBeUpdated.getOwner());

        booksRepository.save(updatedBook);

    }


    public Person getBookOwner(int id) {
        return booksRepository.findById(id).map(Book::getOwner).orElse(null);
    }


    //  Освобождаем книгу
    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(null);
                    book.setTakenAt(null);
                }
        );
    }


    // назначаем книгу
    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(selectedPerson);
                    book.setTakenAt(new Date());
                }
        );
    }

    public Optional<Book> getBookByTitle(String title) {
        return booksRepository.findByTitle(title);
    }
}
