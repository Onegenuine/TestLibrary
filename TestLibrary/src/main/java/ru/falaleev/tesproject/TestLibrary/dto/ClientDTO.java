package ru.falaleev.tesproject.TestLibrary.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.falaleev.tesproject.TestLibrary.models.Book;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ClientDTO {
    @NotEmpty(message = "ФИО клиента не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО должно быть не больше 100 символов")
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;



    @NotEmpty(message = "Название книги не может быть пустым")
    private String title;

    @NotEmpty (message = "ФИО Автора не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО Автора должно быть не больше 100 символов")
    private String author;

    @NotEmpty (message = "ISBN книги не может быть пустым")
    private String isbn;

    //сохранение в это поле времени  когда взяли книгу
    @Temporal(TemporalType.DATE)
    private Date takenAt;
}
