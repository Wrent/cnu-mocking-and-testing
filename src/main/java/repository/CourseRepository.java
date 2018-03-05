package repository;

import exception.CourseNameAlreadyExistsException;
import model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Course save(Course course) throws CourseNameAlreadyExistsException;
    Optional<Course> getByName(String name);
    List<Course> getAll();
}
