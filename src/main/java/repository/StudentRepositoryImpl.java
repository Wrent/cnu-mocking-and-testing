package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
