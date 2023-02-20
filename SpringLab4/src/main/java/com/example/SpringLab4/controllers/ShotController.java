package com.example.SpringLab4.controllers;

import com.example.SpringLab4.model.Shot;
import com.example.SpringLab4.model.util.AreaChecker;
import com.example.SpringLab4.model.util.Validator;
import com.example.SpringLab4.repositories.ShotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/main")
@CrossOrigin
public class ShotController {
    private final ShotRepository shotRepository;
    @Autowired
    public ShotController(ShotRepository shotRepository) {
        this.shotRepository = shotRepository;
    }
    @GetMapping("/init")
    public List<Shot> getAllShotsByOwner(@RequestParam String username) {
        return shotRepository.searchAllByUsername(username);
    }
    @PostMapping("/add")
    public Shot addShot(@RequestBody Shot shot) {
        if (Validator.isValidShot(shot)) {
            shot.setCurrTime(LocalDateTime.now());
            shot.setStatus(AreaChecker.isHit(shot));
            shotRepository.save(shot);
        }
        return shot;
    }
    @DeleteMapping
    public List<Shot> deleteAllByOwner(@RequestParam String username) {
        shotRepository.deleteAllByUsername(username);
        return new ArrayList<Shot>();
    }
}
