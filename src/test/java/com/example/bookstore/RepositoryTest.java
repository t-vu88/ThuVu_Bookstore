package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import com.example.bookstore.model.*;



@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {
	 @Autowired
	    private BookRepository bookRepo;

	 @Autowired
	    private CategoryRepository categoryRepo;
	 
	 @Test
	 public void findByPublicationYearShouldReturnBook () {
		 List<Book> books = bookRepo.findByPublicationYear(2016);
		//assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("The Sun also rises");
	 }
	 
	 @Test
	 public void addNewBook() {
		 Book book = new Book("A Head Full of Ghosts", "Paul Trembley","ISBN434345621394", 2015
		 ,categoryRepo.findByName("Dekkarit").get(0));
		 bookRepo.save(book);
		 assertThat(book.getId()).isNotNull();
	 }
	 
	 @Test
	 public void deleteBook() {
		 List<Book> books = bookRepo.findByPublicationYear(2016);
		 Book book = books.get(0);
		 bookRepo.delete(book);
		 List<Book> newBookList = bookRepo.findByPublicationYear(2016);
		 assertThat(newBookList).hasSize(0);
	     }
	  
}
