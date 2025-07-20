package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DTO.AuthorDTO;
import com.example.Repo.AuthorRepo;
import com.example.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	@Override
	public Author saveAuthor(AuthorDTO dto) {

		Author author = new Author();
		author.setName(dto.getName());
		return authorRepo.save(author);
	}

	@Override
	public List<Author> getAll() {

		return authorRepo.findAll();
	}

}
