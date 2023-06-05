package com.Bikkadit.RestAPIBook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bikkadit.RestAPIBook.model.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
