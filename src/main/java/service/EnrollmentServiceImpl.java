package service;

import exception.CourseIsFullException;
import exception.StudentAlreadyEnrolledException;
import model.Course;
import model.Enrollment;
import model.Student;
import repository.EnrollmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repository;

    public EnrollmentServiceImpl(EnrollmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Enrollment enroll(Course course, Student student) throws StudentAlreadyEnrolledException, CourseIsFullException {
        if (isAlreadyEnrolled(course, student)) {
            throw new StudentAlreadyEnrolledException();
        }
        if (!hasFreeSpots(course)) {
            throw new CourseIsFullException();
        }

        return repository.save(new Enrollment(student, course));
    }

    @Override
    public boolean canEnroll(Course course, Student student) {
        boolean alreadyEnrolled = isAlreadyEnrolled(course, student);

        return !alreadyEnrolled && hasFreeSpots(course);
    }

    private boolean isAlreadyEnrolled(Course course, Student student) {
        return repository.contains(new Enrollment(student, course));
    }

    private boolean hasFreeSpots(Course course) {
        List<Enrollment> enrollmentsForCourse = getEnrollments(course);

        return course.getCapacity() > enrollmentsForCourse.size();
    }

    @Override
    public List<Enrollment> getEnrollments(Course course) {
        return repository.getAll().stream()
                .filter(e -> e.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    @Override
    public List<Enrollment> getEnrollments(Student student) {
        return repository.getAll().stream()
                .filter(e -> e.getStudent().equals(student))
                .collect(Collectors.toList());
    }
}
