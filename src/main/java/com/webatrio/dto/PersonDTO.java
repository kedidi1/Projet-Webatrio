package com.webatrio.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.webatrio.entities.Job;
import com.webatrio.entities.Person;

public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private List<Job> currentJobs;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.age = calculateAge(person.getDateOfBirth());
        this.currentJobs = getCurrentJobs(person.getJobs());
    }


    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public List<Job> getCurrentJobs() {
		return currentJobs;
	}


	public void setCurrentJobs(List<Job> currentJobs) {
		this.currentJobs = currentJobs;
	}


	private int calculateAge(LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    private List<Job> getCurrentJobs(List<Job> jobs) {
        List<Job> currentJobs = new ArrayList();
        LocalDate currentDate = LocalDate.now();

        for (Job job : jobs) {
            if (job.getEndDate() == null || job.getEndDate().isAfter(currentDate)) {
                currentJobs.add(job);
            }
        }

        return currentJobs;
    }
}