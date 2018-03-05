package service;

import exception.CourseNameAlreadyExistsException;
import exception.InvalidParametersException;
import model.Course;
import model.Student;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course addCourse(String name, int capacity) throws CourseNameAlreadyExistsException, InvalidParametersException;

    Optional<Course> getCourseByName(String name);

    List<Student> getStudents(Course course);

    boolean enrollStudent(Course course, Student student);

    float countAverageEvaluationGrade(Course course);
}
