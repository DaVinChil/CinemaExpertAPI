package ru.native_speakers.cinema_expert_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ru.native_speakers.cinema_expert_api.model.Person;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonsRepositoryTest {

    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsRepositoryTest(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    @Test
    void test(){
        Page<Person> allDirectors = personsRepository.findAllDirectors(PageRequest.of(0, 2));
        List<Person> cont = allDirectors.getContent();
        System.out.println(cont.get(0).getFullName());
        System.out.println(cont.get(1).getFullName());

        cont = personsRepository.findAllDirectors(PageRequest.of(0, 1)).getContent();
        System.out.println(cont.get(0).getFullName());
        cont = personsRepository.findAllDirectors(PageRequest.of(1, 1)).getContent();
        System.out.println(cont.get(0).getFullName());
    }
}
