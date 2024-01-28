package ru.falaleev.tesproject.TestLibrary.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;


@Getter
@AllArgsConstructor
@Setter
public class BooksResponse {

  private List<BookDTO> books;
}
