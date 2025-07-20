package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.BookDTO;
import com.example.Service.BookService;
import com.example.entity.Book;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookService service;

	@PostMapping
	public ResponseEntity<Book> create(@RequestBody @Valid BookDTO dto) {
		return new ResponseEntity<>(service.saveBook(dto), HttpStatus.CREATED);
	}

	@GetMapping
	public Page<Book> getAllBooks(@RequestParam(defaultValue = "") String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "id") String sortBy) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return service.getBooks(title, pageable);
	}

}
