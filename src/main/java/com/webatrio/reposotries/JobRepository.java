package com.webatrio.reposotries;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webatrio.entities.Job;
import com.webatrio.entities.Person;

public interface JobRepository  extends JpaRepository<Person, Long>{

	List<Job> findByPersonIdAndStartDateBetween(Long personId, LocalDate startDate, LocalDate endDate);

}
