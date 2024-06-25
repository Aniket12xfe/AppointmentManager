package com.packages.appointments.servlet;

import com.packages.appointments.dao.AppointmentDao;
import com.packages.appointments.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DisplayAppointmentsServlet")
public class DisplayAppointmentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AppointmentDao dao = new AppointmentDao();
            List<Appointment> appointments = dao.getAllAppointments();
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("displayAppointments.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
