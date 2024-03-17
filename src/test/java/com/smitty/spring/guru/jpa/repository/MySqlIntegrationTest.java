package com.smitty.spring.guru.jpa.repository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles({"local"})
@DataJpaTest
@ComponentScan(basePackages = {"com.smitty.spring.guru.jpa.bootstrap"})
@AutoConfigureTestDatabase(replace = Replace.NONE)
class MySqlIntegrationTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("When database is started, we connect to MySQL with 2 books in the book table")
    void verify_initial_state() {
        assertThat(bookRepository.count()).isEqualTo(2L);
    }
}