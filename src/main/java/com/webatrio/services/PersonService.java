package com.webatrio.services;

import java.time.LocalDate;
import java.util.List;

import com.webatrio.dto.PersonDTO;
import com.webatrio.entities.Job;
import com.webatrio.entities.Person;

public interface PersonService {
    List<PersonDTO> getAllPersonsOrderedByNameWithAgeAndCurrentJobs();
    List<Person> getPersonsByCompany(String companyName);
    List<Job> getJobsOfPersonBetweenDates(Long personId, LocalDate startDate, LocalDate endDate);
	Person save(Person person);
}