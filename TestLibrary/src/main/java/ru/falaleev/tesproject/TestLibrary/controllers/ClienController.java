package ru.falaleev.tesproject.TestLibrary.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.falaleev.tesproject.TestLibrary.dto.BookDTO;
import ru.falaleev.tesproject.TestLibrary.dto.BooksResponse;
import ru.falaleev.tesproject.TestLibrary.dto.ClientDTO;
import ru.falaleev.tesproject.TestLibrary.dto.PersonDTO;
import ru.falaleev.tesproject.TestLibrary.models.Book;
import ru.falaleev.tesproject.TestLibrary.models.Person;
import ru.falaleev.tesproject.TestLibrary.service.BooksService;
import ru.falaleev.tesproject.TestLibrary.service.PeopleService;
import ru.falaleev.tesproject.TestLibrary.util.PersonErrorResponse;
import ru.falaleev.tesproject.TestLibrary.util.PersonException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/readers")
public class ClienController {

    private final ModelMapper modelMapper;
    private final BooksService booksService;
    private final PeopleService peopleService;


    @Autowired
    public ClienController(ModelMapper modelMapper, BooksService booksService, PeopleService peopleService) {
        this.modelMapper = modelMapper;
        this.booksService = booksService;
        this.peopleService = peopleService;
    }


    @GetMapping()
    public BooksResponse getBook() {
        // Обычно список из элементов оборачивается в один объект для пересылки
        return new BooksResponse(booksService.findAll().stream().map(this::convertToBookDTO)
                .filter(book -> book.getOwner() != null)
                .collect(Collectors.toList()));
    }

    private BookDTO convertToBookDTO(Book book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

    private Book convertToBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}


