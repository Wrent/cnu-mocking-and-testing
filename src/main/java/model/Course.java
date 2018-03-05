package model;

import java.util.List;

public class Course {
    private final String name;
    private final int capacity;


    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
