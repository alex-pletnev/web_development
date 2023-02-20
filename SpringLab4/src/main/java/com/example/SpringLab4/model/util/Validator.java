package com.example.SpringLab4.model;

import com.example.SpringLab4.entitis.Shot;
import com.example.SpringLab4.entitis.User;

public class Validator {
    public static boolean isValidShot(Shot shot){
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        return (x >= -4 && x <= 4 && y >= -3 && y <= 5 && r >= -4 && r <= 4);
    }
    public static String validateUser(User user) {
        String validateMessage = "success";
        if (user.getUsername() == null || user.getUsername().equals("")) {
            validateMessage = "Username can't be empty!";
        } else if (user.getPassword() == null || user.getPassword().equals("")) {
            validateMessage = "Password can't be empty!";
        } else if (user.getUsername().length() < 4 || user.getUsername().length() > 16) {
            validateMessage = "Username must be in range from 4 to 16!";
        } else if (user.getPassword().length() < 4 || user.getPassword().length() > 16) {
            validateMessage = "Password must be in range from 4 to 16!";
        }
        return validateMessage;
    }


}
