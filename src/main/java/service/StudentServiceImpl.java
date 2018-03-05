package service;

import model.Course;
import model.Student;
import repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    public Student addStudent(String firstName, String lastName, int birthYear) {
        //check nullability
        return null;
    }

    public List<Student> getAllStudents() {
        return null;
    }

    public int getStudentAge(Student student) {
        //testing using current date
        return 0;
    }

    public List<Course> getCourses(Student student) {
        return null;
    }
}
