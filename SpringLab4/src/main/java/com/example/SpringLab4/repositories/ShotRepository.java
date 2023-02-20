package com.example.SpringLab4.repositories;

import com.example.SpringLab4.model.Shot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShotRepository extends JpaRepository<Shot, Long> {
    List<Shot> searchAllByUsername(String username);
    @Transactional
    Optional<Shot> deleteAllByUsername(String username);

}
