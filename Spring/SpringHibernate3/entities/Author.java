package com.example.HibernateRelationships.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Embedded
    //Create instance variable of Address class inside Author class and save it as embedded object.
    private Address address;

    //  List of subjects for author
//    @ElementCollection
//    private List<String> subjects = new ArrayList<String>();


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    private Book book;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
//    private Set<Book> book;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="author_books",
            joinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"))
    private Set<Book> book;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<String> getSubjects() {
//        return subjects;
//    }
//
//    public void setSubjects(List<String> subjects) {
//        this.subjects = subjects;
//    }

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

}
