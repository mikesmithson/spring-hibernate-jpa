package com.smitty.spring.guru.jpa.repository;

import com.smitty.spring.guru.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
}
