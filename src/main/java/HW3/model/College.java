package HW3.model;

import HW3.model.*;
import HW3.utility.*;

public class College {
    private StafList stafList ;
    private CourseList courseList ;
    private StudentList studentList;
    private ProfessorList professorList;
    private PersonList personList = new PersonList();
    private  int idStaff = 1;
    private int idStudent = 2;
    private int idProfessor = 2;
    private int idCourse = 14;
    public Person authentication(String userName, String passWord){
           personList.clear();
           personList.addAll(stafList.getAll());
           personList.addAll(studentList.getAll());
           personList.addAll(professorList.getAll());
           return personList.authentication(userName,passWord);
    }
    public College(StafList stafList,CourseList courseList,StudentList studentList,ProfessorList professorList){
        this.stafList = stafList;
        this.courseList = courseList;
        this.studentList = studentList;
        this.professorList = professorList;
        //courseList.addAll(new Courses().getCourses());
    }
    public void addAdmin(Staff staff){
        stafList.add(staff);
    }


    public void showStudentList()
    {
        System.out.println("------------------------------------------student List-------------------------------------------");
        studentList.show();
    }
    public void showProfessorList(){
        System.out.println("--------------------------------------Professor List-------------------------------------------");
        professorList.show();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println();
    }
    public void removeFromCourseList(Staff staff,String id){
        int idInt = Integer.parseInt(id);
      staff.removeFromCourseList(courseList,idInt);
    }

    public boolean takeCourse(Student student, String id)
    {
        int idCourse = Integer.parseInt(id);
        Course course  = courseList.get(idCourse);
        Course takeCourse =  new Course(course.getId(),course.getName(),course.getUnit(), course.getScore(),false);
        if(student.getCourseList() != null) {
            if (checkTakedCourse(student, takeCourse) & addCourse(takeCourse,student)) {
                student.takeCourse(takeCourse);
                return true ;
            }
        }else if(student.getCourseList() == null) {
            student.takeCourse(takeCourse);
            return true;
        }
        return false;
    }
    //
    private boolean checkTakedCourse(Student student,Course course)
    {

            if(student.getCourseList().contains(course)){
                return false;
            }
            return true;


    }

    private boolean addCourse(Course takeCourse,Student student){
        int avg = student.getAvg();
        if(avg >= 18 ){
            if(student.getCourseList().getSumUnit() < 24){
            //    student.takeCourse(takeCourse);
                return true;
            }else {
                return false;
            }
        }else if(avg < 18){
            if(student.getCourseList().getSumUnit() < 20){
               // student.takeCourse(takeCourse);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public void showStudentTakeCourse(Student student){
        student.getCourseList().showCourseComplete();
    }

    public void removeFromProfessorList(Staff staff,int id){
        staff.removeFromProfessorList(professorList,id);
    }
     public void removeFromStudentList(Staff staff,int id)
     {
         staff.removeFromStudentList(studentList,id);
     }
     public void removeFromStaffList(int idStaff)
     {

             stafList.remove(idStaff);

     }

    public void editCourse(Staff staff,String id,String name,String unit){
        int idInt = Integer.parseInt(id);
        int unitInt = Integer.parseInt(unit);
        staff.editCourse(courseList,idInt,name,unitInt);

    }
    public void editStaff(Staff staff,int id,String nationalCode,String firstName,String lastName,String address,String userName,String password){
       staff.editStaff(stafList,id,nationalCode,firstName,lastName,address,userName,password);

    }
    public void editProfessor(Staff staff,int id,String nationalCode,String firstName,String lastName,String address,String userName,String password,boolean isStaf){
        staff.editProfessor(professorList,id,nationalCode,firstName,lastName,address,userName,password,isStaf);
    }
   public void editStudent(Staff staff,int id,String nationalCode,String firstName,String lastName,String address,String userName,String password,int avg){
    staff.editStudent(studentList,id,nationalCode,firstName,lastName,address,userName,password,avg);
   }


    public void  showStudentInformation(Student student)
    {
        System.out.println("--------------------Student Information-----------------------------");
        System.out.println(student);
    }
    public void showProfessorInformation(Professor professor)
    {
        System.out.println("--------------------Student Information-----------------------------");
        System.out.println(professor);
    }
    public void showStaffList()
    {
        System.out.println("--------------------Staff List-----------------------------");
        stafList.show();
    }
    public void showCoursesList()
    {
        System.out.println("--------------------------------Courses List------------------------------------------------");
        courseList.show();
    }
    public void showReceiptStaff(Staff staff){
        System.out.print(staff + "\t" );
        System.out.println(staff.salary());
        staff.salary();
    }
    public void showReceiptProfessor(Professor professor){
        System.out.println(professor.getFullName() + "  salary Is " + professor.salary());
    }
    public void showStudentCourses(String id){
        int idStudent = Integer.parseInt(id);
        Student student =   studentList.get(idStudent);
        student.showCourseList();
    }


    public void addStudent(Staff staff,String nationalCode,String firstName ,String lastName,String address,String userName,String passWord,int avg){
      staff.addStudent(studentList,new Student(idStudentMaker(),nationalCode,firstName,lastName,address,3,userName,passWord,avg));

    }
    public void addCourse( Staff staff,String name,int unit){
        staff.addCourse(courseList,new Course(idCourseMaker(),name,unit));
        //stafList.get(1).addCourse(courseList,course);
    }
    public void addProfessor(Staff staff,String nationalCode,String firstName ,String lastName,String address,String userName,String passWord,boolean isStaf){
        staff.addProfessor(professorList,new Professor(idProfessorMaker(),nationalCode,firstName,lastName,address,2,userName,passWord,isStaf));
    }
    public void addStaff(Staff staff,String nationalCode,String name, String lastName, String address, String userName, String password)
    {
        int id = idStaffMaker();
        staff.addStaff(stafList,new Staff(id,nationalCode,name,lastName,address,1,userName,password));
    }
    public void setStudentScore(Professor professor ,Student student,String idCourse,String score){
       if(professor.setStudentScore(student,idCourse,score)){
           System.out.println("************set score success*********************");
       }else {
           System.out.println("             score out of range");
       }
    }
    private int idStaffMaker(){
        idStaff++;
        return idStaff;
    }
    private int idStudentMaker()
    {
        idStudent++;
        return idStudent;
    }
    private int idProfessorMaker()
    {

        return ++idProfessor;
    }
    private int idCourseMaker(){
        return ++idCourse;
    }
}
