package com.example.SpringLab4.repositories;

import com.example.SpringLab4.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    List<Person> findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);

}
