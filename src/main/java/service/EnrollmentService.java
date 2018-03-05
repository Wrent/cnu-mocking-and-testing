package service;

import model.Course;
import model.Enrollment;
import model.Student;

import java.util.List;

public interface EnrollmentService {

    //only if canEnroll
    Enrollment enroll(Course course, Student student);

    //check for duplicities, capacity
    boolean canEnroll(Course course, Student student);

    List<Enrollment> getEnrollments(Course course);
    List<Enrollment> getEnrollments(Student student);
}
