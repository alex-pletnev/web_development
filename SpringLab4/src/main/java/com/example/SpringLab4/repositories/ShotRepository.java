package com.example.SpringLab4.repositories;

import com.example.SpringLab4.entitis.Shot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShotRepository extends JpaRepository<Shot, Long> {
}
