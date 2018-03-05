package repository;

import model.Enrollment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    private Set<Enrollment> enrollments = new HashSet<>();

    @Override
    public Enrollment save(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public boolean contains(Enrollment enrollment) {
        return enrollments.contains(enrollment);
    }

    @Override
    public List<Enrollment> getAll() {
        return new ArrayList<>(enrollments);
    }
}
