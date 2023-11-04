import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<Student> enrolledStudents;
public Course(String code, String title, String description, int capacity) {
     this.code = code;
     this.title = title;
     this.description = description;
     this.capacity = capacity;
     this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (registeredCourses.size() < 4 && course.getEnrolledStudents().size() < course.getCapacity()) {
            registeredCourses.add(course);
            course.getEnrolledStudents().add(this);
            System.out.println(name + " registered for course: " + course.getTitle());
        } else {
            System.out.println("Unable to register for course: " + course.getTitle());
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getEnrolledStudents().remove(this);
            System.out.println(name + " dropped course: " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for course: " + course.getTitle());
        }
    }
}
public class CourseRegistrationSystem {
  public static void main(String[] args) {
       Course c1 = new Course("MG8591", "Principles Of Management", "Basic IT course", 30);
       Course c2 = new Course("CS8079", "Human Computer Interaction", "Basic IT course", 25);

        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(2, "Bob");

        s1.registerCourse(c1);
        s2.registerCourse(c1);
        s1.registerCourse(c2);
        s2.registerCourse(c2);

        System.out.println("Course Listings:");
        displayCourseDetails(c1);
        displayCourseDetails(c2);
    }

    public static void displayCourseDetails(Course course) {
        System.out.println("Course Code: " + course.getCode());
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Course Description: " + course.getDescription());
        System.out.println("Course Capacity: " + course.getCapacity());
        System.out.println("Available Slots: " + (course.getCapacity() - course.getEnrolledStudents().size()));
    }
}
