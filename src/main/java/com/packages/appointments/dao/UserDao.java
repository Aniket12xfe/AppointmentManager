package com.packages.appointments.dao;

import com.packages.appointments.model.User;
import com.packages.appointments.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public void saveUser(User user) throws Exception {
        Connection con = DatabaseConnection.initializeDatabase();
        String query = "INSERT INTO users (username, password, name, email) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());
        pstmt.executeUpdate();
        con.close();
    }

    public User validateUser(String username, String password) throws Exception {
        Connection con = DatabaseConnection.initializeDatabase();
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        if (rs.next()) {
            user = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
        }
        con.close();
        return user;
    }
}
