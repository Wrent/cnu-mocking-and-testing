package service;

import exception.CourseIsFullException;
import exception.StudentAlreadyEnrolledException;
import model.Course;
import model.Enrollment;
import model.Student;

import java.util.List;

public interface EnrollmentService {

    Enrollment enroll(Course course, Student student) throws StudentAlreadyEnrolledException, CourseIsFullException;

    boolean canEnroll(Course course, Student student);

    List<Enrollment> getEnrollments(Course course);
    List<Enrollment> getEnrollments(Student student);
}
