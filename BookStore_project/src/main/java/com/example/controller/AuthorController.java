package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.AuthorDTO;
import com.example.Service.AuthorService;
import com.example.entity.Author;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
    public ResponseEntity<Author> create(@RequestBody @Valid AuthorDTO dto) {
        return new ResponseEntity<>(authorService.saveAuthor(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Author> getAll() {
        return authorService.getAll();
    }

}
