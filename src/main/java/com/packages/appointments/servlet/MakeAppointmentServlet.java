package com.packages.appointments.servlet;

import com.packages.appointments.dao.AppointmentDao;
import com.packages.appointments.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MakeAppointmentServlet")
public class MakeAppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AppointmentDao appointmentDao;

    public void init() {
        appointmentDao = new AppointmentDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String description = request.getParameter("description");

        Appointment appointment = new Appointment(username, date, time, description);

        try {
            appointmentDao.saveAppointment(appointment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("home.jsp");
    }
}
