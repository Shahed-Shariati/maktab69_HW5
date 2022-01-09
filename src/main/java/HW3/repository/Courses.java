package HW3.repository;

import HW3.model.Course;

public class Courses {
    private Course[] courses = new Course[14];

    public Course[] getCourses() {
        return courses;
    }

    public Courses() {
        initialCourses();
    }


    private void initialCourses() {
        int[] id = {1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14};
        String[] name = {"BR", "PL", "BB", "CN","HU","JP","CV","AL","CN","ID","PH","PT","KR","KL"};
        int[] unit = {3,2,3,2,3,2,4,3,1,2,3,2,4,2};
        for (int i = 0; i < id.length; i++) {
            courses[i] = new Course(id[i], name[i], unit[i]);
        }
    }
}
