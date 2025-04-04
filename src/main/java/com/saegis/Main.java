package com.saegis;
import java.sql.SQLException;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();


    public static void main(String[] args) throws SQLException {


        System.out.println("-- Welcome to Saegis --");
        System.out.println("** Student Management System **");
        System.out.println("\n");
        System.out.println("Enter your choice: ");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Edit Student");
        System.out.println("4. List Students");
        System.out.println("5. Show Students");
        System.out.println("6. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                DeleteStudent();
                break;
            case 3:
                EditStudent();
                break;
            case 4:
                ShowStudent();
                break;
            case 5:
                break;
        }
    }

    private static void DeleteStudent() {
        System.out.println("Enter Student Id need to delete: ");
        int id = sc.nextInt();

        Student student = new Student(id);
        dao.rvStudent(student);
    }

    private static void EditStudent() {
        System.out.println("Enter Student ID to edit: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new name: ");
        String name = sc.nextLine();

        System.out.println("Enter new age: ");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);
        dao.editStudent(student);
    }

    private static void ShowStudent() throws SQLException {
        System.out.println("** Show Students **");
        System.out.println("\n");
        System.out.printf("%-5s %-20s %-10s\n", "ID", "Name", "Age");
        System.out.println("---------------------------------------------------------");

        try {
            dao.showStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private static void addStudent() {
        System.out.println("Enter student id: ");
        int id = sc.nextInt();

        System.out.println("Enter student name: ");
        String name = sc.next();

        System.out.println("Enter student age: ");
        int age = sc.nextInt();


        Student student = new Student(id, name, age);
        dao.addStudent(student);

    }
}


