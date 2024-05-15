package com.example.sql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
CustomerRepository cpo;
	@RequestMapping("/test")
	public String test()
	{return "this is test for sql";
	
	}
	@RequestMapping("/save")
	public String save(@RequestBody Customer customer)
	{ cpo.save(customer);
	return "Data is saved to database";

	}
	@RequestMapping("/all")
	public List<Customer> alldata()
	{
		return cpo.findAll();
	}
	@RequestMapping("/{id}")
	public Optional<Customer> byid(@PathVariable int id)
	{
		return cpo.findById(id);
	}
	@RequestMapping("/name/{name}")
	public List<Customer> byname(@PathVariable String name)
	{
		return cpo.findByName(name);
	}
	@RequestMapping("/city/{city}")
	public List<Customer> bycity (@PathVariable String city)
	{return cpo.findByCity(city);
	}
	@RequestMapping("/both/{name}/{city}")
	public List<Customer> both(@PathVariable String name , @PathVariable String city)
	{
		return cpo.findByNameAndCity(name, city);
	}
	@RequestMapping("/del/{id}")
	public String del (@PathVariable int id)
	{
		Customer c=cpo.findById(id).get();
		cpo.deleteById(id);
		return "data deleted";
	}
	}
