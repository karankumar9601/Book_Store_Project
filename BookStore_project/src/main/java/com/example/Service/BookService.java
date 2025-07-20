package com.example.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.DTO.BookDTO;
import com.example.entity.Book;

public interface BookService {

	public Book saveBook(BookDTO dto);

	public Page<Book> getBooks(String title, Pageable pageable);

}
