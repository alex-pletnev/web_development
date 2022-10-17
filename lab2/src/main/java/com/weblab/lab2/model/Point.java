package com.weblab.lab2.model;


import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point implements Serializable {
    private double x;
    private double y;
    private double r;
    private String time;
    private String workingTime;
    private boolean status;




    public static String getUtcTime(Date time) {
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

//Local time zone
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");

//Time in UTC
        try {
           return String.valueOf(dateFormatLocal.parse( dateFormatGmt.format(time)));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return "TimeError";
        }
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String httpRowToString() {
        return  "<tr class=\"answer_table\">" +
            "<td class=\"answer_table\">" + x + "</td>" +
            "<td class=\"answer_table\">" + y + "</td>" +
            "<td class=\"answer_table\">" + r + "</td>" +
            "<td class=\"answer_table\">" + time + "</td>" +
            "<td class=\"answer_table\">" + status + "</td>" +
            "<td class=\"answer_table\">" + workingTime + "</td>" +
         "</tr>";
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", time='" + time + '\'' +
                ", workingTime='" + workingTime + '\'' +
                ", status=" + status +
                '}';
    }
}
