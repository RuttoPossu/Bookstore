package hh.backend.bookstore.bookstore.domain;

import hh.backend.bookstore.bookstore.domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
