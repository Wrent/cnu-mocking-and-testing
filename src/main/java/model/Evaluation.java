package model;

import java.util.Optional;

public class Evaluation {
    private final Optional<Grade> grade;

    public Evaluation() {
        this.grade = Optional.empty();
    }

    public Evaluation(Grade grade) {
        this.grade = Optional.of(grade);
    }

    public boolean isEvaluated() {
        return grade.isPresent();
    }

    public Optional<Integer> getGrade() {
        return grade.map(g -> g.getValue());
    }
}
