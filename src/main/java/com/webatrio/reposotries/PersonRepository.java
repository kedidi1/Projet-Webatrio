package com.webatrio.reposotries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webatrio.entities.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByJobsCompanyNameIgnoreCase(String companyName);
	

}
