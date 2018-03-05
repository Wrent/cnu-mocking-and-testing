package model;

import java.util.Objects;

public class Enrollment {
    private final Student student;
    private final Course course;

    private Evaluation evaluation;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.evaluation = new Evaluation();
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void evaluate(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(student, that.student) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student, course);
    }
}
