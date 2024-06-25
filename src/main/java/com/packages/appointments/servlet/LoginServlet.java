package com.packages.appointments.servlet;

import com.packages.appointments.dao.UserDao;
import com.packages.appointments.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userDao.validateUser(username, password);
            if (user != null) {
                request.getSession().setAttribute("username", user.getUsername());
                request.getSession().setAttribute("name", user.getName());
                response.sendRedirect("home.jsp");
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                request.setAttribute("error", "Invalid username or password");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
