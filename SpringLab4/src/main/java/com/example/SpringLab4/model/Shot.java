package com.example.SpringLab4.model;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.service.annotation.PostExchange;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@Entity
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime currTime;
    private Double x;
    private Double y;
    private Double r;
    private Boolean status;
//    @ManyToOne
    private String username;

    HttpStatus httpStatus;

    public Shot() {
        httpStatus = HttpStatus.OK;
    }

}

