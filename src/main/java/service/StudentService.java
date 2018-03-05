package service;

import model.Course;
import model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(String firstName, String lastName, int birthYear);

    List<Student> getAllStudents();

    int getStudentAge(Student student);

    List<Course> getCourses(Student student);
}
