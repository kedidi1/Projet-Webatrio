package com.webatrio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webatrio.dto.JobDTO;
import com.webatrio.services.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/person/{personId}/jobsBetweenDates")
    public List<JobDTO> getJobsOfPersonBetweenDates(
        @PathVariable Long personId,
        @RequestParam  LocalDate startDate,
        @RequestParam  LocalDate endDate
    ) {
        List<JobDTO> jobs = jobService.getJobsOfPersonBetweenDates(personId, startDate, endDate);
        return jobs;
    }

}