package HW3.repository;

import HW3.model.Course;
import HW3.utility.StudentList;

public class StudentCourse {
    StudentList studentList;
    Course[] course ={ new Course(1,"BR",3,0,false),
                        new Course(2,"PL",17,0,false)
                      ,new Course(3,"BB",3,0,false)
                     ,new Course(4,"CN",2,0,false)
                    ,new Course(5,"HU",3,0,false)};



    public StudentCourse(StudentList studentList) {
        this.studentList = studentList;
    }
    //------------------------------------------0 2 2 5
    public void initialStudentCourse(int id,int start,int end)
    {
        for (int i = start; i < end ; i++) {
            studentList.get(id).takeCourse(course[i]);
        }

    }
}
