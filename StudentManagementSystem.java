# StockPriceAnalysis

## Description

This Java program performs a series of stock price analysis tasks, including:
- Calculating the average stock price
- Finding the maximum stock price
- Counting the occurrences of a specific price
- Computing the cumulative sum of stock prices

## Features

1. **Calculate Average Stock Price**:
   - Method: `calculateAveragePrice`
   - Input: Array of stock prices (float[])
   - Output: Average price (float)

2. **Find Maximum Stock Price**:
   - Method: `findMaximumPrice`
   - Input: Array of stock prices (float[])
   - Output: Maximum price (float)

3. **Count Occurrences of a Specific Price**:
   - Method: `countOccurrences`
   - Input: Array of stock prices (float[]), Target price (float)
   - Output: Number of occurrences (int)

4. **Compute Cumulative Sum of Stock Prices**:
   - Method: `computeCumulativeSum`
   - Input: ArrayList of stock prices (ArrayList<Float>)
   - Output: Cumulative sum (ArrayList<Float>)
                             
    Code:
    import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private int age;
    private String grade;

    public Student(String name, int id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    public static void addStudent(String name, int id, int age, String grade) {
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        totalStudents++;
    }

    public static void updateStudent(int id, String name, int age, String grade) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public static void viewStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public static void viewAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    StudentManagement.addStudent(name, id, age, grade);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // consume the newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    System.out.println("Student information updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter ID of student to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    StudentManagement.viewAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
