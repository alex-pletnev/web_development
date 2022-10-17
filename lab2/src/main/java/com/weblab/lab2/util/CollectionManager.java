package com.weblab.lab2.util;

import com.weblab.lab2.model.Point;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

public class CollectionManager {
    private CollectionManager() {
    }
    public static CollectionManager instance = new CollectionManager();
    private  Map<HttpSession, ArrayList<Point>> users = new WeakHashMap<>();

    public synchronized boolean initData(HttpServletRequest req) {
        if (users.containsKey(req.getSession())) {
            req.getSession().setAttribute("history", getPoints(req));
            return false;
        }
        users.put(req.getSession(), new ArrayList<>());
        req.getSession().setAttribute("history", getPoints(req));
        return true;
    }
    public synchronized void addPoint(HttpServletRequest req, Point point) {
        users.get(req.getSession()).add(point);
        req.getSession().setAttribute("history", getPoints(req));
    }
    public synchronized void clear(HttpServletRequest req) {
        users.get(req.getSession()).clear();
        req.getSession().setAttribute("history", getPoints(req));
    }
    public synchronized ArrayList<Point> getPoints(HttpServletRequest req) {
        return  users.get(req.getSession());
    }

}
