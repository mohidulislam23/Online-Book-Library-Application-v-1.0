package com.bjitacademy.securityModule.service;

import com.bjitacademy.securityModule.entity.BooksEntity;
import com.bjitacademy.securityModule.model.BooksRequestModel;
import com.bjitacademy.securityModule.model.UserRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {
    ResponseEntity<Object> booksList();


    /**
     * @param bookId
     */
    void deleteByID(Long bookId);

    BooksEntity getBookById(Long bookId);

    List<BooksEntity> getBookByAuthorName(String author);

    BooksEntity getBookByAuthorNameAndBookName(String authorName, String bookName);

    ResponseEntity<Object> create(BooksRequestModel requestModel);

    ResponseEntity<Object> update(Long bookId, BooksRequestModel requestModel);

}
