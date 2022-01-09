package HW3.model;

import HW3.utility.CourseList;
import HW3.utility.ProfessorList;
import HW3.utility.StafList;
import HW3.utility.StudentList;

public class Staff extends Employee {
    private CourseList courseList;
     private StafList stafList;
     private StudentList studentList;
     private ProfessorList professorList;


    public Staff( int id ,String nationalCode, String firstName, String lastName, String address, int permission, String userName, String password){
        super(id,nationalCode,firstName,lastName,address,permission,userName,password);
        this.courseList = courseList;

    }
    public void removeFromCourseList(CourseList courseList,int id)

    {
        this.courseList = courseList;
        this.courseList.remove(id);
    }
    public void removeFromStudentList(StudentList studentList,int id)
    {
        this.studentList = studentList;
        this.studentList.remove(id);
    }
    public void removeFromProfessorList(ProfessorList professorList,int id){
        this.professorList = professorList;
        this.professorList.remove(id);
    }
    public void editStudent(StudentList studentList,int id,String nationalCode,String firstName,String lastName,String address,String userName,String password ,int avg)
    {
     this.studentList = studentList;
     studentList.get(id).setFirstName(firstName);
     studentList.get(id).setLastName(lastName);
     studentList.get(id).setAddress(address);
     studentList.get(id).setUserName(userName);
     studentList.get(id).setPassWord(password);
     studentList.get(id).setNationalCode(nationalCode);
     studentList.get(id).setAvg(avg);
    }
    public void addStaff(StafList stafList,Staff staff)
    {
        stafList.add(staff);
    }
    public void addStudent(StudentList studentList, Student student)
    {
        this.studentList = studentList;
        this.studentList.add(student);
    }
    public void addCourse(CourseList courseList, Course course)
    {
        this.courseList = courseList;
        this.courseList.add(course);
    }
    public void addProfessor(ProfessorList professorList, Professor professor)
    {
        if(professorList.contains(professor)) {
            System.out.println("--------------------cant-----------------");
        }else {
            this.professorList = professorList;
            this.professorList.add(professor);
        }
    }
    public void editProfessor(ProfessorList professorList,int id,String nationalCode,String name,String lastName,String address,String userName,String passWord,boolean isStaf){
        this.professorList = professorList;
        this.professorList.get(id).setFirstName(name);
        this.professorList.get(id).setLastName(lastName);
        this.professorList.get(id).setPassWord(passWord);
        this.professorList.get(id).setAddress(address);
        this.professorList.get(id).setNationalCode(nationalCode);
        this.professorList.get(id).setUserName(userName);
        this.professorList.get(id).setStaff(isStaf);

    }
    public void editStaff(StafList stafList,int id,String nationalCode,String name,String lastName,String address,String userName,String passWord){
        this.stafList = stafList;
        this.stafList.get(id).setFirstName(name);
        this.stafList.get(id).setLastName(lastName);
        this.stafList.get(id).setAddress(address);
        this.stafList.get(id).setUserName(userName);
        this.stafList.get(id).setPassWord(passWord);
        this.stafList.get(id).setNationalCode(nationalCode);
    }

    public void editCourse(CourseList courseList,int id,String name,int unit){
        this.courseList = courseList;
        this.courseList.edit(id,name,unit);
    }


    @Override
    public int salary() {
        return 5_000_000;
    }

    @Override
    public String toString() {
        return getId()+"\t\t"+ getNationalCode() +"\t\t" + getFirstName() + "\t\t" + getLastName();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
