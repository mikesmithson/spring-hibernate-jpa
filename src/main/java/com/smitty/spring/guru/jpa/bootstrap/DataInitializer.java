package com.smitty.spring.guru.jpa.bootstrap;

import com.smitty.spring.guru.jpa.domain.Book;
import com.smitty.spring.guru.jpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Profile({"local", "default"})
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        Book functionalKotlin = new Book();
        functionalKotlin.setTitle("Functional Kotlin");
        functionalKotlin.setIsbn("123456");
        functionalKotlin.setPublisher("LeanPub");

        Book coroutines = new Book();
        coroutines.setTitle("Kotlin Coroutines");
        coroutines.setIsbn("654321");
        coroutines.setPublisher("LeanPub");

        List<Book> savedBooks = bookRepository.saveAll(List.of(functionalKotlin, coroutines));
        savedBooks.forEach(book -> System.out.println(book.getId() + "- " + book.getTitle()));
    }
}
