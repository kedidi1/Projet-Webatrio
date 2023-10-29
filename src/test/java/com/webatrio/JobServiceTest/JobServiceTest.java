package com.webatrio.JobServiceTest;

 org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.webatrio.dto.JobDTO;
import com.webatrio.entities.Job;
import com.webatrio.reposotries.JobRepository;
import com.webatrio.servicesImpl.JobServiceImpl;

@SpringBootTest
public class JobServiceTest {

    @InjectMocks
    private JobServiceImpl jobService;

    @Mock
    private JobRepository jobRepository;

    private List<Job> testJobs;

    @BeforeEach
    public void setUp() {
        testJobs = new ArrayList<>();
        testJobs.add(new Job(1L, "Company A", "Developer", LocalDate.of(2022, 1, 1), null,null));
        testJobs.add(new Job(2L, "Company B", "Designer", LocalDate.of(2021, 5, 15), LocalDate.of(2022, 6, 30),null);
    }

    @Test
    public void testGetAllJobs() {
        when(jobRepository.findAll()).thenReturn(testJobs);

        List<JobDTO> result = jobService.getAllJobs();

        assertEquals(2, result.size());
        // Ajoutez d'autres assertions pour vérifier le résultat.
    }

    @Test
    public void testGetJobById() {
        Long jobId = 1L;
        Job testJob = testJobs.get(0);

        when(jobRepository.findById(jobId)).thenReturn(Optional.of(testJob));

        JobDTO result = jobService.getJobById(jobId);

        assertEquals(testJob.getId(), result.getId());
        // Ajoutez d'autres assertions pour vérifier le résultat.
    }

    @Test
    public void testCreateJob() {
        JobDTO newJobDTO = new JobDTO(null, "Company C", "Manager", LocalDate.of(2023, 2, 20), null);

        when(jobRepository.save(ArgumentMatchers.any(Job.class))).thenAnswer(invocation -> {
            Job savedJob = invocation.getArgument(0);
            savedJob.setId(3L); 
            }
    }