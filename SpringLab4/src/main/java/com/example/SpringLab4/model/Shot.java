package com.example.SpringLab4.entitis;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
public class Shot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date currTime;
    private Integer x;
    private Double y;
    private Integer r;
    private Boolean status;
//    @ManyToOne
    private String username;

    public Shot() {}
}

