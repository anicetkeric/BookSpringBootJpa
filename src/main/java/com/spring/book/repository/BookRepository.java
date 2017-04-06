package com.spring.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.book.entities.Book;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {

}
