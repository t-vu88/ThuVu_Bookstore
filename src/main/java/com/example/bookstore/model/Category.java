package com.example.bookstore.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Long categoryId;
		private String name;

		@OneToMany(cascade = CascadeType.ALL, mappedBy ="category")
		private List<Book> books;

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public Category(String name) {
			this.name = name;
		}
		
		
		public Category(String name, List<Book> books) {
		
			this.name = name;
			this.books = books;
		}

		public Category() {
			
		}


		

		
		
		
		
}
