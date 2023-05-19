package com.bjitacademy.securityModule.service.impl;

import com.bjitacademy.securityModule.entity.BooksEntity;
import com.bjitacademy.securityModule.model.BooksRequestModel;
import com.bjitacademy.securityModule.repository.BooksRepository;
import com.bjitacademy.securityModule.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

    public final BooksRepository booksRepository;

    @Override
    public ResponseEntity<Object> booksList() {
        List<BooksEntity> books = booksRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @Override
    public void deleteByID(Long bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public BooksEntity getBookById(Long bookId) {
        Optional<BooksEntity> bookOptional = booksRepository.findById(bookId);

        return bookOptional.orElse(null);
    }

    @Override
    public List<BooksEntity> getBookByAuthorName(String authorName) {
        final List<BooksEntity> byAuthor = booksRepository.findByAuthorName(authorName);
        return byAuthor;
    }

    @Override
    public BooksEntity getBookByAuthorNameAndBookName(String authorName, String bookName) {
        return booksRepository.findByAuthorNameAndBookName(authorName, bookName);
    }

    @Override
    public ResponseEntity<Object> create(BooksRequestModel requestModel) {
        BooksEntity booksEntity = BooksEntity.builder()
                .bookId(requestModel.getBookId())
                .authorName(requestModel.getAuthorName())
                .bookName(requestModel.getBookName())
                .build();
        BooksEntity savedBooksEntity = booksRepository.save(booksEntity);
        return new ResponseEntity<>(savedBooksEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> update(Long bookId, BooksRequestModel requestModel) {
        Optional<BooksEntity> books = booksRepository.findById(bookId);
        BooksEntity booksEntity = books.get();

        booksEntity.setAuthorName(requestModel.getAuthorName());
        booksEntity.setBookName(requestModel.getBookName());

        return  new ResponseEntity<>(booksRepository.save(booksEntity), HttpStatus.OK);

    }

}
