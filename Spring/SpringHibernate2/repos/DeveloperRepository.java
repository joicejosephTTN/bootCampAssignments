package com.example.SpringHibernate.repos;

import com.example.SpringHibernate.entities.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}