package com.example.Service;

import java.util.List;

import com.example.DTO.AuthorDTO;
import com.example.entity.Author;

public interface AuthorService {

	public Author saveAuthor(AuthorDTO dto);

	public List<Author> getAll();

}
