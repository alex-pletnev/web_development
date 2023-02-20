package com.example.lab3;

import com.example.lab3.dao.ShotDao;
import com.example.lab3.util.Validators;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
//@NoArgsConstructor
@Named("shotBean")
@ApplicationScoped
public class ShotBean implements Serializable {

    private ShotDao shotDao;
    private Shot shot;
    private List<Shot> shotsList;

//    @PostConstruct
//    public void postConstruct() {
//        shot = new Shot();
//        shotDao = new ShotDao();
//        shotDao.createEntityManager();
//        shotsList = shotDao.getShotsFromDB();
//    }
//
    public ShotBean() {
        this.shotDao = new ShotDao();
        this.shot = new Shot();
        shotDao.createEntityManager();
        this.shotsList = shotDao.getShotsFromDB();
    }

    public void clear(){
        shotDao.clearShotsInBD();
        shotsList = shotDao.getShotsFromDB();
    }
    public void add(){
        LocalDateTime startTime = LocalDateTime.now(ZoneOffset.UTC);
        if(Validators.isValid(shot)) {
            shot.setStatus(Validators.isHit(shot));
            shot.setCurrentTime(startTime.minusMinutes(0).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            shot.setScriptTime(Math.round(LocalDateTime.now().minusNanos(startTime.getNano()).getNano() * 0.001));
            shotsList.add(shot);
            shotDao.addShotToDB(shot);
            shot = new Shot();
        }else{
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) context.getResponse();
            response.setStatus(500);
        }
    }

    public void addThroughPlot(){
        String sx = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("x");
        String sy = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("y");
        String sr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("r");
        shot.setX(Double.parseDouble(sx));
        shot.setY(Double.parseDouble(sy));
        shot.setR(Double.parseDouble(sr));
        add();
    }


}
