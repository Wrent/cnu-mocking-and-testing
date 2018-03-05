package repository;

import model.Enrollment;

import java.util.List;

public interface EnrollmentRepository {
    Enrollment save(Enrollment enrollment);
    List<Enrollment> getAll();

    boolean contains(Enrollment enrollment);
}
