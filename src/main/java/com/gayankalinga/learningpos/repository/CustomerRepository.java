package com.gayankalinga.learningpos.repository;

import com.gayankalinga.learningpos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
- this is the database work based on the entity
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
