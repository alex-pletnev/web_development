package com.example.SpringLab4.model.util;

import com.example.SpringLab4.model.Shot;

public class AreaChecker {
    public static boolean isHit(Shot shot){
        if (shot.getR() == 0) {
            return false;
        } else if (shot.getR() < 0) {
            return isNegCircleZone(shot.getX(), shot.getY(), shot.getR())
                    || isNegTriangleZone(shot.getX(), shot.getY(), shot.getR())
                    || isNegRectangleZone(shot.getX(), shot.getY(), shot.getR());
        }
        return isCircleZone(shot.getX(), shot.getY(), shot.getR())
                || isTriangleZone(shot.getX(), shot.getY(), shot.getR())
                || isRectangleZone(shot.getX(), shot.getY(), shot.getR());
    }
    private static boolean isRectangleZone(double x, double y, double r){
        return (x>0) && (y<0) && (x<=r/2) && (y>=(-r));
    }
    private static boolean isNegRectangleZone(double x, double y, double r) {
        r = -r;
        return (x<0) && (y>0) && (x<=r/2) && (y<=(r));
    }
    private static boolean isNegCircleZone(double x, double y, double r){
        r = -r;
        return (x*x + y*y <= r*r && (x>0) && (y<0));
    }
    private static boolean isNegTriangleZone(double x, double y, double r) {
        r = -r;
        if (x < 0 && y < 0) {
            double x1 = -r / 2;
            double x2 = 0;
            double x3 = 0;
            double y1 = 0;
            double y2 = -r / 2;
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
        } else return false;    }
    private static boolean isCircleZone(double x, double y, double r){
        return (x*x + y*y <= r*r && (x<=0) && (y>=0));
    }
    private static boolean isTriangleZone(double x, double y, double r) {
        if (x > 0 && y > 0) {
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
