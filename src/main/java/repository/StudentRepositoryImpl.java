package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}
