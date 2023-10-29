package com.webatrio.dto;

import java.time.LocalDate;

import com.webatrio.entities.Job;

public class JobDTO {
    private Long id;
    private String companyName;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;

    public JobDTO(Job job) {
        this.id = job.getId();
        this.companyName = job.getCompanyName();
        this.position = job.getPosition();
        this.startDate = job.getStartDate();
        this.endDate = job.getEndDate();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

    
}