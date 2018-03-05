package service;

import model.Course;
import model.Student;

import java.util.List;

public interface CourseService {
    Course addCourse(String name, String capacity);
    void removeCourseByName(String name);

    Course getCourseByName(String name);

    List<Student> getStudents(Course course);

    Course enrollStudent(Course course, Student student);
}
