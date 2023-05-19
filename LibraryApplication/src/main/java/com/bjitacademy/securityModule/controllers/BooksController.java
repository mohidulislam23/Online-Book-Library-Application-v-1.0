package com.bjitacademy.securityModule.controllers;

import com.bjitacademy.securityModule.entity.BooksEntity;
import com.bjitacademy.securityModule.model.BooksRequestModel;
import com.bjitacademy.securityModule.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {
    private final BooksService booksService;
    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<Object> booksList(){
        return booksService.booksList();
    }

    @GetMapping("/id/{bookId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<Object> getBookById(@PathVariable Long bookId) {
        BooksEntity book = booksService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book);
    }

    @GetMapping("/author/{authorName}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<List<BooksEntity>> getBookByAuthorName(@PathVariable String authorName){
        List<BooksEntity> books = booksService.getBookByAuthorName(authorName);
        if(books == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{authorName}/{bookName}")
    //@PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    public ResponseEntity<BooksEntity> getBookByAuthorNameAndBookName(@PathVariable String authorName, @PathVariable String bookName){
        BooksEntity books = booksService.getBookByAuthorNameAndBookName(authorName, bookName);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody BooksRequestModel requestModel){
        return booksService.create(requestModel);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Object> Update(@PathVariable Long bookId, @RequestBody BooksRequestModel requestModel){
        return booksService.update(bookId, requestModel);
    }

    @DeleteMapping("/delete/{bookId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteBook(@PathVariable Long bookId){
        booksService.deleteByID(bookId);
    }
}
