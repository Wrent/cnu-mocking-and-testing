package service;

import exception.CourseIsFullException;
import exception.CourseNameAlreadyExistsException;
import exception.InvalidParametersException;
import exception.StudentAlreadyEnrolledException;
import model.Course;
import model.Enrollment;
import model.Grade;
import model.Student;
import repository.CourseRepository;
import util.MathUtil;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CourseServiceImpl implements CourseService {
    private final EnrollmentService enrollmentService;
    private final CourseRepository repository;

    public CourseServiceImpl(EnrollmentService enrollmentService, CourseRepository repository) {
        this.enrollmentService = enrollmentService;
        this.repository = repository;
    }

    @Override
    public Course addCourse(String name, int capacity) throws CourseNameAlreadyExistsException, InvalidParametersException {
        if (name == null) {
            throw new InvalidParametersException();
        }
        return repository.save(new Course(name, capacity));
    }

    @Override
    public Optional<Course> getCourseByName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return repository.getByName(name);
    }

    @Override
    public boolean enrollStudent(Course course, Student student) {
        try {
            enrollmentService.enroll(course, student);
            return true;
        } catch (StudentAlreadyEnrolledException e) {
            return false;
        } catch (CourseIsFullException e) {
            return false;
        }
    }

    @Override
    public float countAverageEvaluationGrade(Course course) {
        List<Integer> grades = enrollmentService.getEnrollments(course).stream()
                .filter(enrollment -> enrollment.getEvaluation().isEvaluated())
                .map(enrollment -> enrollment.getEvaluation().getGrade())
                .filter(Optional::isPresent)
                .map(g -> g.get())
                .collect(Collectors.toList());

        return MathUtil.getAverageOfList(grades);
    }

    @Override
    public List<Student> getStudents(Course course) {
        return enrollmentService.getEnrollments(course).stream()
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }
}
