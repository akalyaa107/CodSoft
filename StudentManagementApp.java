import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        return students.stream()
                .filter(student -> student.getRollNumber() == rollNumber)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        loadStudentData(sms);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(sms, scanner);
                    break;
                case 2:
                    editStudent(sms, scanner);
                    break;
                case 3:
                    removeStudent(sms, scanner);
                    break;
                case 4:
                    searchStudent(sms, scanner);
                    break;
                case 5:
                    displayAllStudents(sms);
                    break;
                case 6:
                    saveStudentData(sms);
                    System.out.println("Exiting Student Management System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addStudent(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        sms.addStudent(student);
    }

    private static void editStudent(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Roll Number to Edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        Student student = sms.searchStudent(rollNumber);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.print("Enter New Student Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter New Grade: ");
            String newGrade = scanner.nextLine();

            student.setName(newName);
            student.setGrade(newGrade);
            System.out.println("Student information updated successfully.");
        }
    }

    private static void removeStudent(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Roll Number to Remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        sms.removeStudent(rollNumber);
    }

    private static void searchStudent(StudentManagementSystem sms, Scanner scanner) {
        System.out.print("Enter Roll Number to Search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student Found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents(StudentManagementSystem sms) {
        ArrayList<Student> students = sms.getAllStudents();
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void loadStudentData(StudentManagementSystem sms) {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int rollNumber = Integer.parseInt(parts[1]);
                    String grade = parts[2];
                    Student student = new Student(name, rollNumber, grade);
                    sms.addStudent(student);
                }
}
        } catch (IOException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
    }

    private static void saveStudentData(StudentManagementSystem sms) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            ArrayList<Student> students = sms.getAllStudents();
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }
}

