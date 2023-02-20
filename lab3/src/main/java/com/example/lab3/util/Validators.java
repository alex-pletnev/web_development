package com.example.lab3.util;

import com.example.lab3.Shot;

public class Validators {
    public static boolean isValid(Shot shot){
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        return (x >= -5 && x <= 5 && y >= -3 && y <= 3 && r >= 2 && r <= 5);
    }

    public static boolean isHit(Shot shot){
        return isCircleZone(shot.getX(), shot.getY(), shot.getR())
                || isTriangleZone(shot.getX(), shot.getY(), shot.getR())
                || isRectangleZone(shot.getX(), shot.getY(), shot.getR());
    }
    private static boolean isRectangleZone(double x, double y, double r){
        return (x<=0) && (y<=0) && (x>=(-1)*r) && (y>=(-1)*r/2);
    }
    private static boolean isCircleZone(double x, double y, double r){
        return (x*x + y*y <= (r/2)*(r/2) && (x<=0) && (y>=0));
    }
    private static boolean isTriangleZone(double x, double y, double r) {
        if (x >= 0 && y >= 0) {
            double x1 = r / 2;
            double x2 = 0;
            double x3 = 0;
            double y1 = 0;
            double y2 = r / 2;
            double y3 = 0;
            double p1 = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
            double p2 = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
            double p3 = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);
            if (p1 == 0 || p2 == 0 || p3 == 0) {
                return true;
            }
            if (p1 > 0 && p2 > 0 && p3 > 0) {
                return true;
            } else return p1 < 0 && p2 < 0 && p3 < 0;
        } else return false;
    }
}
