package com.example.sql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

	List<Customer> findByName(String name);

	List<Customer> findByCity(String city);

	List<Customer> findByNameAndCity(String name, String city);

	
}
