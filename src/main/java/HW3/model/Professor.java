package HW3.model;

import HW3.utility.CourseList;
import HW3.utility.StudentList;

public class Professor extends Employee {
    private StudentList studentList;
    private CourseList courseList  = new CourseList();
    private int sumUnit;
    private boolean isStaff;
    public Professor(int id,String nationalCode,String firstName,String lastName,String address,int permission,String userName,String password,boolean isStaff){
        super(id,nationalCode,firstName,lastName,address,permission,userName,password);
        this.isStaff = isStaff;
    }
    public Professor(int id,String nationalCode,String firstName,String lastName,String address,int permission,String userName,String password,boolean isStaff,Course[] courses){
        super(id,nationalCode,firstName,lastName,address,permission,userName,password);
        this.isStaff = isStaff;
        this.courseList.addAll(courses);
    }
    public boolean setStudentScore(Student student,String id,String score )
    {
        int idCourse = Integer.parseInt(id);
        int intScore = Integer.parseInt(score);
        if(intScore >=0 & intScore <= 20) {
            student.getCourseList().get(idCourse).setScore(intScore);
            return true;
        }
        return false;
    }
    @Override
    public int salary() {
        if(isStaff){
            return courseList.getSumUnit() * 1_000_000 + 5_000_000;
        }
        return courseList.getSumUnit() * 1_000_000;
    }


    @Override
    public String toString()
    {
         return  getId()+"\t\t"+ getNationalCode() +"\t\t" + getFirstName() + "\t\t" + getLastName() +"\t\t ";
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void takeCourse(Course course, int term){
        courseList.add(course);
    }
//    public CourseList getCourseList() {
//        return courseList;
//    }
}
