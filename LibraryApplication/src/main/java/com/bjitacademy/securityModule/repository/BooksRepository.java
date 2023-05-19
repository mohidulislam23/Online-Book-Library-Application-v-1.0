package com.bjitacademy.securityModule.repository;

import com.bjitacademy.securityModule.entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Long> {
    List<BooksEntity> findByAuthorName(String authorName);
    BooksEntity findByAuthorNameAndBookName(String authorName, String bookName);
}
