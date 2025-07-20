package com.example.DTO;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Component
@Data
public class BookDTO {
	   @NotBlank(message = "Title cannot be blank")
	    private String title;

	    @NotNull(message = "Author ID is required")
	    private Long authorId;

}
