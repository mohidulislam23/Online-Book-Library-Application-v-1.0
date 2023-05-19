package com.bjitacademy.securityModule.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksRequestModel {
    @NotEmpty
    @Size (min = 1, message = "The Book ID must not be empty. ")
    private Long bookId;
    private String authorName;
    private String bookName;
}
