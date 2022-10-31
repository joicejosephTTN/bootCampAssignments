package com.example.HibernateRelationships;

import com.example.HibernateRelationships.entities.Address;
import com.example.HibernateRelationships.entities.Author;
import com.example.HibernateRelationships.entities.Book;
import com.example.HibernateRelationships.repos.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class HibernateRelationshipsApplicationTests {

	@Autowired
	AuthorRepository authorRepo;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void testOneToOne_AuthorBook(){
//		Author author = new Author();
//		author.setName("Khalil Gibran");
//
//		Address address = new Address();
//		address.setStreetNumber(11);
//		address.setLocation("Some Nagar");
//		address.setState("Delhi");
//		author.setAddress(address);
//
//		Book book = new Book();
//		book.setBookName("The Prophet");
//		author.setBook(book);
//
//		authorRepo.save(author);
//
//	}

//	@Test
//	public void testOneToMany_AuthorBook(){
//		Author author = new Author();
//		author.setName("Mark Mason");
//
//		Address address = new Address();
//		address.setStreetNumber(52);
//		address.setLocation("ABC Colony");
//		address.setState("Mumbai");
//		author.setAddress(address);
//
//		Book newBook = new Book();
//		HashSet<Book> books = new HashSet<>();
//		newBook.setBookName("Atomic Habits");
//
//		books.add(newBook);
//		newBook.setAuthor(author);
//
//		author.setBook(books);
//
//		authorRepo.save(author);
//
//	}

	@Test
	public void testManyToMany(){
		Author author = new Author();
		author.setName("Mark Mason");

		Address address = new Address();
		address.setStreetNumber(52);
		address.setLocation("ABC Colony");
		address.setState("Mumbai");
		author.setAddress(address);

		HashSet<Book> books=new HashSet<>();
		Book book1=new Book();

		book1.setBookName("Black Beauty");
		books.add(book1);

		author.setBook(books);
		authorRepo.save(author);

	}
}
