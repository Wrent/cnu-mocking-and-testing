package service;

import exception.CourseIsFullException;
import exception.StudentAlreadyEnrolledException;
import model.Course;
import model.Enrollment;
import model.Student;
import org.easymock.IAnswer;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseServiceImplTest {

    private EnrollmentService mockEnrollmentService;
    private CourseService courseService;


    @Before
    public void setUp() throws Exception {
        mockEnrollmentService = mock(EnrollmentService.class);
        courseService = new CourseServiceImpl(mockEnrollmentService, null);
    }

    @Test
    public void testEnrollStudent() throws Exception {
        Course course = new Course("Biology", 15);
        Student student = new Student("Adam", "Kucera", 1992);

        expectEnrollCall(course, student);

        replay(mockEnrollmentService);

        boolean result = courseService.enrollStudent(course, student);

        assertTrue(result);
    }

    @Test
    public void testEnrollStudentCapacityException() throws Exception {
        Course course = new Course("Biology", 0);
        Student student = new Student("Adam", "Kucera", 1992);

        expectEnrollCall(course, student);

        replay(mockEnrollmentService);

        boolean result = courseService.enrollStudent(course, student);

        assertFalse(result);
    }

    private void expectEnrollCall(Course course, Student student) throws StudentAlreadyEnrolledException, CourseIsFullException {
        expect(mockEnrollmentService.enroll(course, student)).andAnswer(new IAnswer<Enrollment>() {
            @Override
            public Enrollment answer() throws Exception {
                Course courseParam = (Course) getCurrentArguments()[0];
                Student studentParam = (Student) getCurrentArguments()[1];

                if (course.getCapacity() == 0) {
                    throw new CourseIsFullException();
                } else {
                    return new Enrollment(studentParam, courseParam);
                }
            }
        });
    }
}
