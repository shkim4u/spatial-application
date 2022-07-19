package com.example.demo.reader;

import com.example.demo.model.aggregate.Person;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class MysqlDataReader {
    @Bean
    public JpaCursorItemReader<Person> getReader(EntityManagerFactory entityManagerFactory) {
        return new JpaCursorItemReaderBuilder<Person>()
                .name("personMysqlItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT p from Person p ORDER BY p.id DESC")
                .maxItemCount(5)
                .build();
    }
}
