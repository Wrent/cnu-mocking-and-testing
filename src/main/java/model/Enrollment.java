package model;

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
}
