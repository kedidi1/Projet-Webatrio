package com.webatrio.servicesImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.webatrio.dto.PersonDTO;
import com.webatrio.entities.Job;
import com.webatrio.entities.Person;
import com.webatrio.reposotries.JobRepository;
import com.webatrio.reposotries.PersonRepository;
import com.webatrio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<PersonDTO> getAllPersonsOrderedByNameWithAgeAndCurrentJobs() {
        List<Person> persons = personRepository.findAll(Sort.by(Sort.Order.asc("lastName").ignoreCase()));
        List<PersonDTO> personDTOs = new ArrayList();

        for (Person person : persons) {
            PersonDTO personDTO = new PersonDTO(person);
            personDTO.setAge(calculateAge(person.getDateOfBirth()));
            personDTO.setCurrentJobs(getCurrentJobs(person.getJobs()));
            personDTOs.add(personDTO);
        }

        return personDTOs;
    }

    @Override
    public List<Person> getPersonsByCompany(String companyName) {
        return personRepository.findByJobsCompanyNameIgnoreCase(companyName);
    }

    @Override
    public List<Job> getJobsOfPersonBetweenDates(Long personId, LocalDate startDate, LocalDate endDate) {
        return jobRepository.findByPersonIdAndStartDateBetween(personId, startDate, endDate);
    }

    private int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    private List<Job> getCurrentJobs(List<Job> jobs) {
        List<Job> currentJobs = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();

        for (Job job : jobs) {
            if (job.getEndDate() == null || job.getEndDate().isAfter(currentDate)) {
                currentJobs.add(job);
            }
        }

        return currentJobs;
    }
}