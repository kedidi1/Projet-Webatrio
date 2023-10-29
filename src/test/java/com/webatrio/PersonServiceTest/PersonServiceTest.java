package com.webatrio.PersonServiceTest;

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
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.webatrio.dto.PersonDTO;
import com.webatrio.entities.Person;
import com.webatrio.reposotries.PersonRepository;
import com.webatrio.servicesImpl.PersonServiceImpl;

@SpringBootTest
public class PersonServiceTest {

   @InjectMocks
   private PersonServiceImpl personService;

   @Mock
   private PersonRepository personRepository;

   private List<Person> testPersons;

   @BeforeEach
   public void setUp() {
       testPersons = new ArrayList<>();
       testPersons.add(new Person(1L, "John", "Doe", LocalDate.of(1990, 1, 1), new ArrayList<>()));
       testPersons.add(new Person(2L, "Alice", "Smith", LocalDate.of(1985, 5, 15), new ArrayList<>()));
   }

   @Test
   public void testGetAllPersons() {
       when(personRepository.findAll()).thenReturn(testPersons);

       List<Person> result = personRepository.findAll();
      

       assertEquals(2, result.size());
   }



   @Test
   public void testCreatePerson() {
       Person newPersonDTO = new Person(null, "Jane", "Smith", LocalDate.of(1995, 3, 10), new ArrayList<>());

       when(personRepository.save(ArgumentMatchers.any(Person.class))).thenAnswer(invocation -> {
           Person savedPerson = invocation.getArgument(0);
           savedPerson.setId(3L); 
           return savedPerson;
       });

       Person result = personService.save(newPersonDTO);

       assertEquals(3L, result.getId());
   }


}