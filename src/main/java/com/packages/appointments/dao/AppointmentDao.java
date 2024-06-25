package com.packages.appointments.dao;

import com.packages.appointments.model.Appointment;
import com.packages.appointments.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    public void saveAppointment(Appointment appointment) throws Exception {
        Connection con = DatabaseConnection.initializeDatabase();
        String query = "INSERT INTO appointments (username, date, time, description) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, appointment.getUsername());
        pstmt.setString(2, appointment.getDate());
        pstmt.setString(3, appointment.getTime());
        pstmt.setString(4, appointment.getDescription());
        pstmt.executeUpdate();
        con.close();
    }

    public void deleteAppointment(int id) throws Exception {
        Connection con = DatabaseConnection.initializeDatabase();
        String query = "DELETE FROM appointments WHERE id=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
        con.close();
    }

    public List<Appointment> getAllAppointments() throws Exception {
        Connection con = DatabaseConnection.initializeDatabase();
        String query = "SELECT * FROM appointments";
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        List<Appointment> appointments = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String date = rs.getString("date");
            String time = rs.getString("time");
            String description = rs.getString("description");
            Appointment appointment = new Appointment(id, username, date, time, description);
            appointments.add(appointment);
        }
        con.close();
        return appointments;
    }
}
