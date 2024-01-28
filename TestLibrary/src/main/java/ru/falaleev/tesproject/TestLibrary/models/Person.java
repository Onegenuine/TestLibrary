package ru.falaleev.tesproject.TestLibrary.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

/*
ФИО, дата рождения
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Person")
public class Person {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //ФИО
    @NotEmpty(message = "ФИО клиента не может быть пустым")
    @Size(min = 0, max = 100, message = "ФИО должно быть не больше 100 символов")
    @Column(name = "full_name")
    private String fullName;




    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

}
