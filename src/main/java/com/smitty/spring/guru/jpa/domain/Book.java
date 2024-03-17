package com.smitty.spring.guru.jpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;
    public Book(String title, String isbn, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String isbn;

    @Getter
    @Setter
    private String publisher;
}
