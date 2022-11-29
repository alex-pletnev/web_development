package com.weblab.lab2;

import com.weblab.lab2.util.CollectionManager;
import com.weblab.lab2.model.Point;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "areaCheckServlet", value = "/checkServlet")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        double x = Double.parseDouble(req.getParameter("x"));
        double y = Double.parseDouble(req.getParameter("y"));
        int r = Integer.parseInt(req.getParameter("r"));
        String time = Point.getUtcTime(new Date());
        boolean status = checkHit(x, y, r);
        String workingTime = String.valueOf(System.currentTimeMillis() - startTime);
        CollectionManager.instance.addPoint(req, new Point(x, y, r, time, status, workingTime));
        resp.getWriter().print(status);
        //resp.sendRedirect(resp.encodeRedirectURL("/result.jsp"));

    }
    private boolean checkHit(double x, double y, int r) {
        //1 part
        if (x > 0 && y > 0) {
            double x1 = r;
            double x2 = 0;
            double x3 = 0;
            double y1 = 0;
            double y2 = r;
            double y3 = 0;
            double p1 = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
            double p2 = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
            double p3 = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);
            if (p1 == 0 || p2 == 0 || p3 == 0) {
                return true;
            }
            if (p1 > 0 && p2 > 0 && p3 > 0) {
                return true;
            } else return p1 < 0 && p2 < 0 && p3 < 0;            }
        //2 part
        if (x <= 0 && y >= 0) {
            return false;
        }
        //3 part
        if (x <= 0 && y <= 0) {
            if (x >= -(r/2) && y >= -r) {
                return true;
            } else return false;
        }
        //part 4
        if (x >= 0 && y <= 0) {
            return x*x + y*y <= r*r;
        }
        return false;
    }

}


