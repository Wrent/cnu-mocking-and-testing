package service;

import exception.CourseIsFullException;
import exception.StudentAlreadyEnrolledException;
import model.Course;
import model.Enrollment;
import model.Student;
import org.junit.Before;
import org.junit.Test;
import repository.EnrollmentRepository;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

public class EnrollmentServiceImplTest {

    private EnrollmentService service;
    private EnrollmentRepository mockRepository;

    @Before
    public void setUp() throws Exception {
        mockRepository = mock(EnrollmentRepository.class);
        service = new EnrollmentServiceImpl(mockRepository);
    }

    @Test
    public void testEnrollSuccessful() throws StudentAlreadyEnrolledException, CourseIsFullException {
        Course course = new Course("Mathematics", 20);
        Student student = new Student("Petr", "Novak", 1990);
        Enrollment mockEnrollment = new Enrollment(student, course);

        expect(mockRepository.save(anyObject(Enrollment.class))).andReturn(mockEnrollment);
        expect(mockRepository.contains(anyObject(Enrollment.class))).andReturn(false);
        expect(mockRepository.getAll()).andReturn(new ArrayList<>());
        replay(mockRepository);

        Enrollment enrollment = service.enroll(course, student);

        assertNotNull(enrollment);
        assertEquals(course, enrollment.getCourse());
        assertEquals(student, enrollment.getStudent());
        assertFalse(enrollment.getEvaluation().isEvaluated());

        verify(mockRepository);
    }

    @Test(expected = CourseIsFullException.class)
    public void testEnrollCapacityFull() throws CourseIsFullException, StudentAlreadyEnrolledException {
        Course course = new Course("Mathematics", 0);
        Student student = new Student("Petr", "Novak", 1990);

        expect(mockRepository.contains(anyObject(Enrollment.class))).andReturn(false);
        expect(mockRepository.getAll()).andReturn(new ArrayList<>());
        replay(mockRepository);

        service.enroll(course, student);

        verify(mockRepository);
    }
}
