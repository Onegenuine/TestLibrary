package ru.falaleev.tesproject.TestLibrary.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.falaleev.tesproject.TestLibrary.models.Book;

import java.util.Date;
import java.util.List;

@Data
public class PersonDTO {
    @NotEmpty(message = "ФИО клиента не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО должно быть не больше 100 символов")
    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;


    private List<Book> books;



}
