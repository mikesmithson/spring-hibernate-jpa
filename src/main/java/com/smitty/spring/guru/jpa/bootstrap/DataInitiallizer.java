package com.smitty.spring.guru.jpa.bootstrap;

import com.smitty.spring.guru.jpa.domain.Book;
import com.smitty.spring.guru.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitiallizer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book functionalKotlin = new Book();
        functionalKotlin.setTitle("Functional Kotlin");
        functionalKotlin.setPublisher("LeanPub");

        Book coroutines = new Book();
        coroutines.setTitle("Kotlin Coroutines");
        coroutines.setPublisher("LeanPub");

        List<Book> savedBooks = bookRepository.saveAll(List.of(functionalKotlin, coroutines));
        savedBooks.forEach(book -> System.out.println(book.getId() + "- " + book.getTitle()));
    }
}
