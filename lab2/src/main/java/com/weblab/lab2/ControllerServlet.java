package com.weblab.lab2;

import com.weblab.lab2.util.CollectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "controllerServlet", value = "/controller")

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CollectionManager.instance.initData(req);
        if ("true".equals(req.getParameter("clean"))) {
            req.getRequestDispatcher("/cleaner").forward(req, resp);
        }
        else {
            try {
                double x = Double.parseDouble(req.getParameter("x"));
                double y = Double.parseDouble(req.getParameter("y"));
                int r = Integer.parseInt(req.getParameter("r"));
                req.getRequestDispatcher("/checkServlet").forward(req, resp);
            } catch (NumberFormatException ex) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }
}
