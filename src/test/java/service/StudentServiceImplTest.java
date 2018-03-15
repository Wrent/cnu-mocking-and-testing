package service;

import model.Student;
import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class StudentServiceImplTest {

    private StudentService service;
    private Clock clock;

    @Before
    public void setUp() throws Exception {
        clock = mock(Clock.class);
        service = new StudentServiceImpl(null, null, clock);
    }

    @Test
    public void testGetStudentAge() {
        expect(clock.instant()).andReturn(Instant.ofEpochSecond(1521038220));
        expect(clock.getZone()).andReturn(ZoneId.of("UTC"));
        replay(clock);

        Student student = new Student("Adam", "Kucera", 1992);
        int studentAge = service.getStudentAge(student);

        assertEquals(26, studentAge);

        verify(clock);
    }
}
