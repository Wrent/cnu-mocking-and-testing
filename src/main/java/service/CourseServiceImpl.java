package service;

import model.Course;
import model.Enrollment;
import model.Student;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private EnrollmentService enrollmentService;

    public Course addCourse(String name, String capacity) {
        return null;
    }

    public void removeCourseByName(String name) {

    }

    public Course getCourseByName(String name) {
        return null;
    }

    public Course enrollStudent(Course course, Student student) {
        //testing capacity, exception? we can use IAnswer here? -> EnrollmentService
        return null;
    }

    public List<Student> getStudents(Course course) {
        return null;
    }
}
