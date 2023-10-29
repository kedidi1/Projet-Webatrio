package com.webatrio.servicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webatrio.dto.JobDTO;
import com.webatrio.entities.Job;
import com.webatrio.reposotries.JobRepository;
import com.webatrio.services.JobService;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<JobDTO> getJobsOfPersonBetweenDates(Long personId, LocalDate startDate, LocalDate endDate) {
        List<Job> jobs = jobRepository.findByPersonIdAndStartDateBetween(personId, startDate, endDate);
        List<JobDTO> jobDTOs = new ArrayList();

        for (Job job : jobs) {
            JobDTO jobDTO = new JobDTO(job);
            jobDTOs.add(jobDTO);
        }

        return jobDTOs;
    }

	public List<JobDTO> getAllJobs() {
		// TODO Auto-generated method stub
		return null;
		//return List<Job> jobs = jobRepository.findAll();

	}

}