package model;

public enum Grade {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6);


    Grade(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}
