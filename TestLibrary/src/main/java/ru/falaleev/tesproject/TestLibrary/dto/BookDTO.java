package ru.falaleev.tesproject.TestLibrary.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.falaleev.tesproject.TestLibrary.models.Person;

import java.util.Date;

@Getter
@Setter
public class BookDTO {



    @NotEmpty(message = "Название книги не может быть пустым")
    private String title;

    @NotEmpty(message = "ФИО Автора не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО Автора должно быть не больше 100 символов")
    private String author;

    @NotEmpty(message = "ISBN книги не может быть пустым")
    private String isbn;

    //сохранение в это поле времени  когда взяли книгу
    @Temporal(TemporalType.DATE)
    private Date takenAt;

    private PersonDTO owner;

}
