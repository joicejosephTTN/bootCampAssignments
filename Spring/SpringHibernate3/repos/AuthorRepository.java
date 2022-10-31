package com.example.HibernateRelationships.repos;

import com.example.HibernateRelationships.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}