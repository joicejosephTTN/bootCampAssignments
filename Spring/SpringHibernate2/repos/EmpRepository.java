package com.example.SpringHibernate.repos;

import com.example.SpringHibernate.entities.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
}