package ru.falaleev.tesproject.TestLibrary.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.falaleev.tesproject.TestLibrary.models.Book;
import ru.falaleev.tesproject.TestLibrary.service.BooksService;

@Component
public class BookValidator implements Validator {

    private final BooksService booksService;

    @Autowired
    public BookValidator(BooksService booksService) {
        this.booksService = booksService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;
        if (booksService.getBookByTitle(book.getTitle()).isPresent()){
            errors.rejectValue("title", "", "Книга с таким наименованием  существует");
        }
    }
}
