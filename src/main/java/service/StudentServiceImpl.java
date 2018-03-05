package service;

import exception.InvalidParametersException;
import model.Course;
import model.Enrollment;
import model.Student;
import repository.StudentRepository;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final EnrollmentService enrollmentService;
    private final Clock clock;

    public StudentServiceImpl(StudentRepository repository, EnrollmentService enrollmentService, Clock clock) {
        this.repository = repository;
        this.enrollmentService = enrollmentService;
        this.clock = clock;
    }

    public Student addStudent(String firstName, String lastName, int birthYear) throws InvalidParametersException {
        if (firstName == null || lastName == null) {
            throw new InvalidParametersException();
        }
        return repository.save(new Student(firstName, lastName, birthYear));
    }

    public List<Student> getAllStudents() {
        return repository.getAll();
    }

    public int getStudentAge(Student student) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(clock.instant(), clock.getZone());
        return localDateTime.getYear() - student.getYearOfBirth();
    }

    public List<Course> getCourses(Student student) {
        return enrollmentService.getEnrollments(student).stream()
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());
    }
}
