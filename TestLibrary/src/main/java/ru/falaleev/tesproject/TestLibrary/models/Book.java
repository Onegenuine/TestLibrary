package ru.falaleev.tesproject.TestLibrary.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


/*
   наименование, автор, ISBN
    */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty (message = "Название книги не может быть пустым")
    @Column(name = "title")
    private String title;

    @NotEmpty (message = "ФИО Автора не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО Автора должно быть не больше 100 символов")
    @Column(name = "author")
    private String author;

    @NotEmpty (message = "ISBN книги не может быть пустым")
    @Column(name = "isbn")
    private String isbn;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    //сохранение в это поле времени  когда взяли книгу
    @Temporal(TemporalType.DATE)
    @Column(name = "taken_at")
    private Date takenAt;

    @Transient
    private boolean expired;

}
