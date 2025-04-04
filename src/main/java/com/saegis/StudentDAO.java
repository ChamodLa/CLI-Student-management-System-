package com.saegis;

import java.sql.*;

public class StudentDAO {
    private static Connection conn;

    public StudentDAO() {
        conn = DatabaseConnection.getConnection();
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO STUDENT(id, name, age) VALUES(?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.executeUpdate();
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rvStudent(Student student) {
        String sql = "DELETE FROM STUDENT WHERE ID=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editStudent(Student student) {
        String sql = "UPDATE STUDENT SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName()); // Set name
            pstmt.setInt(2, student.getAge());     // Set age
            pstmt.setInt(3, student.getId());      // Where ID = ?

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with ID: " + student.getId());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating student: " + e.getMessage());
        }
    }

    public void showStudent() throws SQLException {
        String sql = "SELECT * FROM STUDENT";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.printf("%-5d %-20s %-10d\n", id, name, age);

        }

    }
}
