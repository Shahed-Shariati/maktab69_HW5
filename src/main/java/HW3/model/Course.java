package HW3.model;

import java.util.Objects;

public class Course {
    private int id;
    private String name;
    private int unit;
    private int score;//student
    private boolean isPassed;

    public Course(int id, String name, int unit, int score, boolean isPassed) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.score = score;
        this.isPassed = isPassed;
    }

    public Course(int id, String name, int unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

//    public void edit(String name,int unit){
//        this.name = name;
//        this.unit = unit;
//    }

    public String getName() {
        return name;
    }

    public int getUnit() {
        return unit;
    }

    public int getScore() {
        return score;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  id + " \t\t\t" + name + "\t\t\t\t"+ unit  ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
