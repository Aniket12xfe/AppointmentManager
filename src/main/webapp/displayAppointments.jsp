<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.packages.appointments.model.Appointment" %>
<%@ page import="com.packages.appointments.dao.AppointmentDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Display Appointments</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Existing Appointments</h1>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Appointment> appointments = null;
                    try {
                        AppointmentDao dao = new AppointmentDao();
                        appointments = dao.getAllAppointments();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    if (appointments != null && !appointments.isEmpty()) {
                        for (Appointment appointment : appointments) {
                %>
                    <tr>
                        <td><%= appointment.getId() %></td>
                        <td><%= appointment.getUsername() %></td>
                        <td><%= appointment.getDate() %></td>
                        <td><%= appointment.getTime() %></td>
                        <td><%= appointment.getDescription() %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5" class="text-center">No appointments found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
