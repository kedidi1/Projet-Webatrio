package com.webatrio.services;

import java.time.LocalDate;
import java.util.List;

import com.webatrio.dto.JobDTO;

public interface JobService {
    List<JobDTO> getJobsOfPersonBetweenDates(Long personId, LocalDate startDate, LocalDate endDate);
}