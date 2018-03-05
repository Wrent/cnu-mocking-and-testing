package repository;

import exception.CourseNameAlreadyExistsException;
import model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CourseRepositoryImpl implements CourseRepository {
    private List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) throws CourseNameAlreadyExistsException {
        boolean alreadyContainsThisName = courses.stream()
                .anyMatch(c -> c.getName().equals(course.getName()));

        if (alreadyContainsThisName) {
            throw new CourseNameAlreadyExistsException();
        }

        courses.add(course);
        return course;
    }

    @Override
    public Optional<Course> getByName(String name) {
        return courses.stream()
                .filter(course -> course.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Course> getAll() {
        return courses;
    }
}
