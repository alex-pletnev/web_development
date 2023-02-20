package com.example.SpringLab4.model.util;

import com.example.SpringLab4.model.Person;
import com.example.SpringLab4.model.Shot;

public class Validator {
    public static boolean isValidShot(Shot shot){
        double x = shot.getX();
        double y = shot.getY();
        double r = shot.getR();
        return (x >= -5 && x <= 5 && y >= -5 && y <= 5 && r >= -4 && r <= 4);
    }
    public static String validateUser(Person person) {
        String validateMessage = "success";
        if (person.getUsername() == null || person.getUsername().equals("")) {
            validateMessage = "Username can't be empty!";
        } else if (person.getPassword() == null || person.getPassword().equals("")) {
            validateMessage = "Password can't be empty!";
        } else if (person.getUsername().length() < 4 || person.getUsername().length() > 16) {
            validateMessage = "Username must be in range from 4 to 16!";
        } else if (person.getPassword().length() < 4 || person.getPassword().length() > 16) {
            validateMessage = "Password must be in range from 4 to 16!";
        }
        return validateMessage;
    }


}
