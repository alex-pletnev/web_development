package com.weblab.lab2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point implements Serializable {
    private double x;
    private double y;
    private int r;
    private String time;
    private boolean status;
    private String workingTime;

    public static String getUtcTime(Date time) {
        // create a clock
        Clock cl = Clock.systemUTC();

        // create an ZonedDateTime object using now(Clock)
        ZonedDateTime lt
                = ZonedDateTime.now(cl);

        return lt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        SimpleDateFormat dateFormatUtc = new SimpleDateFormat("HH:mm:ss");
//        dateFormatUtc.setTimeZone(TimeZone.getTimeZone("UTC"));
//
////Local time zone
//        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("HH:mm:ss");
//
////Time in UTC
//        try {
//           return String.valueOf(dateFormatLocal.parse( dateFormatUtc.format(time)));
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            return "TimeError";
//        }
    }




    public String httpRowToString() {
        return "<td class=\"answer_table\">" + String.format("%.3f", x) + "</td>" +
            "<td class=\"answer_table\">" + String.format("%.3f", y) + "</td>" +
            "<td class=\"answer_table\">" + r + "</td>" +
            "<td class=\"answer_table\">" + time + "</td>" +
            "<td class=\"answer_table\">" + status + "</td>" +
            "<td class=\"answer_table\">" + workingTime + "</td>";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0 && r == point.r && status == point.status && Objects.equals(time, point.time) && Objects.equals(workingTime, point.workingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, r, time, status, workingTime);
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
