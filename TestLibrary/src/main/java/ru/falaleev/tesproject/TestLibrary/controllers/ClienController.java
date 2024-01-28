package ru.falaleev.tesproject.TestLibrary.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.falaleev.tesproject.TestLibrary.dto.BookDTO;
import ru.falaleev.tesproject.TestLibrary.dto.BooksResponse;
import ru.falaleev.tesproject.TestLibrary.dto.ClientDTO;
import ru.falaleev.tesproject.TestLibrary.dto.PersonDTO;
import ru.falaleev.tesproject.TestLibrary.models.Book;
import ru.falaleev.tesproject.TestLibrary.models.Person;
import ru.falaleev.tesproject.TestLibrary.service.BooksService;
import ru.falaleev.tesproject.TestLibrary.service.PeopleService;

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
                .collect(Collectors.toList()));
    }

//    @GetMapping()
//    public List<PersonDTO>  getPerson() {
//        // Обычно список из элементов оборачивается в один объект для пересылки
//        return peopleService.findAll().stream().map(this::convertToPersonDTO)
//                .collect(Collectors.toList());
//    }

//    @GetMapping()
//    public List<BookDTO>  getBooks() {
//        // Обычно список из элементов оборачивается в один объект для пересылки
//        return booksService.findAll().stream().map(this::convertToBookDTO)
//                .collect(Collectors.toList());
//    }

    private BookDTO convertToBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    private Book convertToBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }


    private ClientDTO convertToClientDTO(PersonDTO personDTO) {
        return modelMapper.map(personDTO, ClientDTO.class);
    }

}


