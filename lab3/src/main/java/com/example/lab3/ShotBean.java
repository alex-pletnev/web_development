package com.example.lab3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Named("shotBean")
@ApplicationScoped
public class ShotBean implements Serializable {

    private Shot shot = new Shot();
    private List<Shot> shotList = new ArrayList<>();

    public void add(){
        shotList.add(shot);
        shot = new Shot();
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
