package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.DTO.BookDTO;
import com.example.Repo.AuthorRepo;
import com.example.Repo.BookRepo;
import com.example.entity.Author;
import com.example.entity.Book;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private AuthorRepo authorRepo;
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book saveBook(BookDTO dto) {

		Author author = authorRepo.findById(dto.getAuthorId())
				.orElseThrow(() -> new RuntimeException("Author not found"));
		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setAuthor(author);
		return bookRepo.save(book);
	}

	@Override
	public Page<Book> getBooks(String title, Pageable pageable) {

		return (title == null || title.isEmpty()) ? bookRepo.findAll(pageable)
				: bookRepo.findByTitleContaining(title, pageable);
	}

}
