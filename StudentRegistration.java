import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int id;
    String name;
    List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
class CourseRegistrationSystem {
    List<Course> courseDatabase;
    List<Student> studentDatabase;

    public CourseRegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }

    public void registerStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        int studentId = studentDatabase.size() + 1; // Generate a unique ID
        Student student = new Student(studentId, studentName);

        studentDatabase.add(student);

        System.out.println("Student " + student.name + " with ID " + student.id + " has been registered.");
    }

    public void registerStudentForCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter course code: ");
        String courseCode = scanner.next();

        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (student.registeredCourses.size() < 5 && course.capacity > 0) {
                student.registeredCourses.add(course);
                course.capacity--;
                System.out.println(student.name + " has successfully registered for " + course.title);
            } else {
                System.out.println("Registration failed. Either the student has reached the maximum number of courses or the course is full.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    public void removeCourse(Student student, Course course) {
        student.registeredCourses.remove(course);
        course.capacity++;
        System.out.println(student.name + " has successfully dropped " + course.title);
    }

    public void displayCourseListing() {
        System.out.println("Course Listing:");
        for (Course course : courseDatabase) {
            System.out.println("Code: " + course.code);
            System.out.println("Title: " + course.title);
            System.out.println("Description: " + course.description);
            System.out.println("Capacity: " + course.capacity);
            System.out.println("Schedule: " + course.schedule);
            System.out.println();
        }
    }
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
    
    Student findStudentById(int id) {
        for (Student student : studentDatabase) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    Course findCourseByCode(String code) {
        for (Course course : courseDatabase) {
            if (course.code.equals(code)) {
                return course;
            }
        }
        return null;
    }
}

public class StudentRegistration {
    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Course c1 = new Course("CSE101", "Introduction to Computer Science", "Fundamentals of programming", 30, "Mon/Wed 10:00 AM - 11:30 AM");
        Course c2 = new Course("MAT202", "Calculus II", "Advanced calculus concepts", 25, "Tue/Thu 1:00 PM - 2:30 PM");
        Course c3 = new Course("NET101", "Network Engineering Fundamentals", "Introduction to network concepts", 25, "Mon/Wed 2:00 PM - 3:30 PM");
        Course c4 = new Course("BIO201", "Advanced Biology", "In-depth study of biological sciences", 20, "Tue/Thu 10:00 AM - 11:30 AM");
        Course c5 = new Course("CHEM301", "Organic Chemistry", "Study of organic compounds and reactions", 15, "Mon/Fri 1:00 PM - 2:30 PM");
        Course c6 = new Course("PSYCH101", "Introduction to Psychology", "Fundamental concepts in psychology", 30, "Wed/Fri 10:00 AM - 11:30 AM");
        Course c7 = new Course("ART202", "Art History", "Survey of major art movements and works", 25, "Tue/Thu 2:00 PM - 3:30 PM");
        Course c8 = new Course("MATH301", "Linear Algebra", "Study of linear equations and vector spaces", 20, "Mon/Wed 10:00 AM - 11:30 AM");
        // Add more courses as needed

        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);
        system.addCourse(c4);
        system.addCourse(c5);
        system.addCourse(c6);
        system.addCourse(c7);
        system.addCourse(c8);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Display Course Listing");
            System.out.println("2. Register Student");
            System.out.println("3. Register Student for Course");
            System.out.println("4. Remove Course Registration");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayCourseListing();
                    break;
                case 2:
                    system.registerStudent();
                    break;
                case 3:
                    system.registerStudentForCourse();
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();

                    Student student = system.findStudentById(studentId);
                    Course course = system.findCourseByCode(courseCode);

                    if (student != null && course != null) {
                        system.removeCourse(student, course);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }
}
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
