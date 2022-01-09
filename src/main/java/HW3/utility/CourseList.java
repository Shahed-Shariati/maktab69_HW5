package HW3.utility;

import HW3.model.Course;

import java.util.Arrays;

public class CourseList {

    private Course[] courses;
    int index = 0;
    public CourseList(){
        courses =new Course[]{};

    }

    public Course[] getCourses() {
        return courses;
    }

    public int getSumUnit(){
        int sum = 0;
        for (Course item:courses) {
            sum += item.getUnit();
        }
        return sum;
    }
    public boolean add(Course element) {
        int length = courses.length;
        courses = Arrays.copyOf(courses, length + 1);
        courses[length] = element;
        return true;
    }
    public Course get(int id){
        for (Course item: courses ) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return courses.length == 0;
    }
    public int size(){
        return courses.length;
    }


    public void clear()
    {
        courses =new Course[]{};
    }
    public void edit(int id,String name,int unit){
        get(id).setName(name);
        get(id).setUnit(unit);
    }
    public void add(int index, Course element){
        int length = courses.length;
        courses = Arrays.copyOf(courses, length + 1);
        for (int i = courses.length - 1; i > index; i--) {
            courses[i] = courses[i - 1];
        }
        courses[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i <courses.length ; i++) {
            if(courses[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private  void removeByIndex(int index)
    {

        if(courses.length > 0 && index <= courses.length-1) {
            for (int arrayIndex = index; arrayIndex < courses.length - 1; arrayIndex++) {
                courses[arrayIndex] = courses[arrayIndex + 1];
            }
            courses = Arrays.copyOf(courses, courses.length - 1);
        }
    }

    public void addAll(Course[] Course){
        for (Course item: Course) {
            add(item);
        }
    }
    public void showCourseComplete()
    {
        System.out.println("id    ||  Course name  ||  unit ||  score  ||");
        for (Course course:courses) {
            System.out.println( course.getId()+ "\t\t\t"+ course.getName() +"\t\t\t\t"+    course.getUnit()+"\t\t\t"+   course.getScore());
        }
    }
    public void show(){
        System.out.println(" id  ||  course name  ||  unit");
        for (Course course: courses) {
            System.out.println(course);
//            if(course.getId() <= 9){
//                System.out.println(course.getId() + "\t\t\t" + course.getName()+"\t\t"+course.getUnit());
//            }else {
//                System.out.println(course.getId() + "\t\t\t" + course.getName()+"\t\t"+course.getUnit());
//            }
        }
    }

    public boolean contains(Course course)
    {


        for (Course item: courses) {
            if(item != null) {
                if (item.getId() == course.getId()) {

                   return true;
                }
            }
        }
        return false;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(courses)
//                ;
//    }

}
