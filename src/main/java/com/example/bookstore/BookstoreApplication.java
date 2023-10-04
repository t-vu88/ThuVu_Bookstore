package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookRepository;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.CategoryRepository;

import com.example.bookstore.model.AppUser;
import com.example.bookstore.model.AppUserRepository;
@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository categoryRepo, AppUserRepository userRepo) {
		return (args) -> {
			log.info("save a couple of books");
			
			
			categoryRepo.save(new Category ("Lasten kirja"));
			categoryRepo.save(new Category ("Kaunokirjallisuus"));
			categoryRepo.save(new Category ("Jännitys"));
			categoryRepo.save(new Category ("Dekkarit"));
			
			repository.save(new Book("The Sun also rises","Ernest Hemingway","9781501121968",2016,categoryRepo.findByName("Kaunokirjallisuus").get(0)));
			repository.save(new Book("Pikku Prinssi", "Antoine de Saint-Exupéry","9789510069851",1997,categoryRepo.findByName("Lasten kirja").get(0)));	
			
			// Create users: admin/admin, user/user
			AppUser user1 = new AppUser("user", "$2a$10$6P0zGJv.1aiDWjLzImPQZeWugo.cHgkXEPUh1Gts216lUEXaFbE42","abc@gmail.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0L0DXGZTYF8E0zTILw7rf.uW8EB9zDfTe8l5InYfHsCogHTViXzHa","def@gmail.com", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
			System.out.println("in command line runner");
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
