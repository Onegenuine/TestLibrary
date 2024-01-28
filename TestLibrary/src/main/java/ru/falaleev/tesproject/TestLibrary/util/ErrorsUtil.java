package ru.falaleev.tesproject.TestLibrary.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsUtil {
    //все ошибки из bildingResulta конкетенирум в онду строку StringBuldera
    public static void returnErrorsToClient(BindingResult bindingResult) {

        StringBuilder errorMsq = new StringBuilder();

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMsq.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                    .append(";");

        }
        throw new PersonException(errorMsq.toString());

    }
}