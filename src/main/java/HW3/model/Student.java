package HW3.model;

import HW3.utility.CourseList;

public class Student extends Person {
    private CourseList courseList = new CourseList();
    private int score;
    private int avg;

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public Student(int id, String nationalCode, String firstName, String lastName, String address, int permission, String userName, String password, int avg){
        super(id,nationalCode,firstName,lastName,address,permission,userName,password);
        this.avg = avg;
    }
    public void showCourseList()
    {
        System.out.println(" id  ||  course name  ||  unit  || score ");
        for (Course course:courseList.getCourses()) {
            System.out.println(course.getId() + " \t\t\t" + course.getName() + "\t\t\t\t"+ course.getUnit()+"\t\t"+course.getScore() );
        }
    }
    public void takeCourse(Course course)
    {
        courseList.add(course);
    }

    @Override
    public String toString() {
         return  getId()+"\t\t"+ getNationalCode() +"\t\t" + getFirstName() + "\t\t" + getLastName() +"\t\t "+ getAvg();

    }

    public int getAvg() {
        return avg;
    }

    public CourseList getCourseList() {
        return courseList;
    }
}
