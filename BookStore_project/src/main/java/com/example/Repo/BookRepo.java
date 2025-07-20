package com.example.Repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
	Page<Book> findByTitleContaining(String title, Pageable pageable);

}
