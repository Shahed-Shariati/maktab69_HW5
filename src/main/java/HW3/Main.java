package HW3;

import HW3.model.*;
import HW3.repository.*;
import HW3.utility.*;

import java.util.Scanner;

public class Main {
    static Scanner input;

    public static void main(String[] args) {

        //region initial Application
        StafList stafList = new StafList();
        CourseList courseList = new CourseList();
        StudentList studentList = new StudentList();
        ProfessorList professorList = new ProfessorList();
        professorList.addAll(new Professors().getProfessors());
        courseList.addAll(new Courses().getCourses());
        studentList.addAll(new Students().getStudents());
        Staff staff = new Staff(1,"373","Admin","Admin","admin",1,"admin","admin");
        PersonList personList = new PersonList();
        personList.addAll(stafList.getAll());
        College college = new College(stafList,courseList,studentList,professorList);
        college.addAdmin(staff);
        StudentCourse studentCourse = new StudentCourse(studentList);
        studentCourse.initialStudentCourse(1,0,2);
        studentCourse.initialStudentCourse(2,2,5);
        //endregion

        while (true) {


            System.out.println("Enter user Name and Password:(default: admin admin)");
            String[] commond = getUserInput().trim().split(" +");
            if(commond[0].equals("exit")){
                break;
            }


            Person person = college.authentication(commond[0], commond[1]);
            if (person == null){
                System.out.println(" username or password is invalide");
            }else {
                System.out.println("---------user " + person.getFirstName() + " is login-------");
                System.out.println();
                while (true) {

 //       ------------------------------------------------------------------------------------Staff Menu--------------------------------------------------------------
                    if (person != null && person.getPermission() == 1) {

                        Staff staff1 = stafList.getByNationalCode(person.getNationalCode());

                        staffMenu();
                        String input = getUserInput();
                        if (input.equals("1")) {

                            college.showStudentList();
                            System.out.println();
                            System.out.println("enter student : national code || firstname || lastname  || address || username || password || last avg:\n" +
                                    "(example:       1234567891          shahed     shariati    tehran         sh          sh          15)\n Enter (back) to main menu");
                            String[] student = getUserInput().trim().split(" +");
                            if (student[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.addStudent(staff1, student[0], student[1], student[2], student[3], student[4], student[5], Integer.parseInt(student[6]));
                                college.showStudentList();
                                System.out.println();
                            }
                        } else if (input.equals("2")) {

                            college.showStudentList();
                            System.out.println();
                            System.out.println("-----------------------------------------Edit student-------------------------------------------");
                            System.out.println("choice id student to edit");
                            int idStudent = Integer.parseInt(getUserInput().trim());

                            System.out.println(" nationalcode firstname lastname address username password avg \n(example: 37329194568 shahed shariati tehran sh sh 15)");
                            String[] student = getUserInput().trim().split(" +");
                            if (student[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.editStudent(staff1, idStudent, student[0], student[1], student[2], student[3], student[4], student[5], Integer.parseInt(student[6]));
                            }

                        } else if (input.equals(input.equals("3"))) {

                            college.showStudentList();
                            System.out.println();
                            System.out.println("------------------------------------------Delete student-------------------------------------------");
                            System.out.println("Enter id student to delete");
                            String[] student = getUserInput().trim().split(" ");
                            if (student[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.removeFromStudentList(staff1, Integer.parseInt(student[0]));
                                college.showStudentList();
                            }

                        } else if (input.equals("4")) {

                            college.showProfessorList();
                            System.out.println();

                            System.out.println("enter Professor : national code firstname lastname address username password staff:\n(example: 1111 shahed shariati tehran sh sh isstaff / nostaff)\nEnter (back) to main menu");
                            String[] professor = getUserInput().trim().split(" +");
                            if (professor[0].equals("back")) {
                                System.out.println();
                            } else {
                                boolean isStaf = (professor[6].equals("isstaf")) ? true : false;
                                college.addProfessor(staff1, professor[0], professor[1], professor[2], professor[3], professor[4], professor[5], isStaf);
                                college.showProfessorList();
                                System.out.println();
                            }
                        } else if (input.equals("5")) {

                            college.showProfessorList();
                            System.out.println();
                            System.out.println("---------------------------------------------Edit Professor----------------------------------------------");
                            System.out.println("choice id student to edit");
                            int idProfessor =Integer.parseInt(getUserInput().trim());
                            System.out.println("enter Professor  :id national code firstname lastname address username password staff:\n(example:2 1111 shahed shariati tehran sh sh isstaff/nostaff)");
                            String[] professor = getUserInput().trim().split(" ");
                            if (professor[0].equals("back")) {
                                System.out.println();
                            } else {
                                boolean isStaf = (professor[6].equals("isstaf")) ? true : false;
                                college.editProfessor(staff1, idProfessor, professor[0], professor[1], professor[2], professor[3], professor[4], professor[5], isStaf);
                                college.showProfessorList();
                                System.out.println();
                            }
                        } else if (input.equals("6")) {

                            college.showProfessorList();
                            System.out.println();
                            System.out.println("------------------------------------------Delete Professor-------------------------------------------");
                            System.out.println("Enter id professor to delete");
                            String[] professor = getUserInput().trim().split(" ");
                            if (professor[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.removeFromProfessorList(staff1, Integer.parseInt(professor[0]));
                                college.showProfessorList();
                            }


                        } else if (input.equals("7")) {

                            college.showStaffList();
                            System.out.println();
                            System.out.println("--------------------Enrol Staff ---------------------------");
                            System.out.println("Example: firstname lastname address username password:");
                            String[] staf = getUserInput().trim().split(" ");
                            if (staf[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.addStaff(staff1, staf[0], staf[1], staf[2], staf[3], staf[4], staf[5]);
                            }
                        } else if (input.equals("8")) {

                            college.showStaffList();
                            System.out.println();
                            System.out.println("--------------------Edit Staff -----------------------------");
                            System.out.println("edit staff: id NationalCode  name lastname address user password:\n (example: 1 111 shahed shariati teh user pass)");
                            String[] editStaff = getUserInput().trim().split(" ");
                            if (editStaff[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.editStaff(staff1, Integer.parseInt(editStaff[0]), editStaff[1], editStaff[2], editStaff[3], editStaff[4], editStaff[5], editStaff[6]);
                            }


                        } else if (input.equals("9")) {

                            college.showStaffList();
                            System.out.println();
                            System.out.println("--------------------Delete Staff-----------------------------");
                            System.out.println("enter staff id to delete:");
                            String idStaff = getUserInput();
                            if (idStaff.equals("back")) {
                                System.out.println();
                            } else {
                                int id = Integer.parseInt(idStaff);

                                if (staff1.getId() == id && person.getPermission() == 1) {
                                    System.out.println("ccccccccccccccccccccccccc");
                                } else {
                                    college.removeFromStaffList(id);
                                }
                            }
                            college.showStaffList();
                        } else if (input.equals("10")) {

                            college.showCoursesList();
                            System.out.println();
                            System.out.println("Example:courseName course unit:\n (example:  Riazi 3)\n Enter \"back\" to back main menu");
                            String[] course = getUserInput().trim().split(" ");
                            if (course[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.addCourse(staff, course[0], Integer.parseInt(course[1]));
                            }
                        } else if (input.equals("11")) {
                            //fixme edit course

                            college.showCoursesList();

                            System.out.println();
                            System.out.println("choice id student to edit");
                            String idCourse =getUserInput().trim();
                            System.out.println("--------------------------Edit Course-------------------------------------");
                            System.out.println("Enter  course name  course unit to edit: (example  PH 6)\n Enter \"back\" to back main menu ");
                            String[] course = getUserInput().trim().split(" +");
                            if (course[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.editCourse(staff1, idCourse, course[0], course[1]);
                                college.showCoursesList();
                                System.out.println();
                            }
                        } else if (input.equals("12")) {

                            college.showCoursesList();
                            System.out.println();
                            System.out.println("--------------------------Delete Course-------------------------------------");
                            System.out.println("Enter id course to delete: (example 2 )\n Enter \"back\" to back main menu ");
                            String[] course = getUserInput().trim().split(" ");
                            if (course[0].equals("back")) {
                                System.out.println();
                            } else {
                                college.removeFromCourseList(staff1, course[0]);
                                college.showCoursesList();
                                System.out.println();
                            }
                        } else if (input.equals("13")) {
                            college.showStudentList();

                        } else if (input.equals("14")) {
                            college.showProfessorList();
                        } else if (input.equals("15")) {
                            college.showStaffList();
                        } else if (input.equals("17")) {
                            break;
                        } else if(input.equals("16")){
                          college.showReceiptStaff(staff1);
                        }else  if (input.equals("back")) {
                            System.out.println();
                        } else if (Integer.parseInt(input) > 17 || Integer.parseInt(input) < 0) {
                            System.out.println("Enter valid choice");
                        }

//-------------------------------------------------------------------------------Professor menu------------------------------------------------------------------------------------------------------

                    } else if (person != null && person.getPermission() == 2) {
                        Professor professor = professorList.get(person.getId());
                        professorMenu();
                        String input = getUserInput();
                        if (input.equals("1")) {
                            college.showProfessorInformation(professor);
                        } else if (input.equals("2")) {
                            college.showStudentList();
                            System.out.println("Choice student id:\n(Enter back to return main menu)");
                            String idStudent = getUserInput().trim();
                            if(idStudent.equalsIgnoreCase("back")){
                                System.out.println();
                            }else {
                                System.out.println("        " + studentList.get(Integer.parseInt(idStudent)).getFullName());
                                college.showStudentCourses(idStudent);
                                System.out.println("Enter Course id:");
                                String idCourse = getUserInput().trim();
                                System.out.println("Enter course score:");
                                String score = getUserInput().trim();
                                Student student = studentList.get(Integer.parseInt(idStudent));
                                college.setStudentScore(professor,student,idCourse,score);
                                college.showStudentCourses(idStudent);
                            }

                        } else if (input.equals("3")) {
                            System.out.println(3);
                        } else if (input.equals("back")) {
                            System.out.println();
                        } else if (input.equals("5")) {
                            break;
                        }else if(input.equals("4")){
                            college.showReceiptProfessor(professor);
                        }else if (Integer.parseInt(input) > 5 || Integer.parseInt(input) < 0) {
                            System.out.println("Enter valid choice");
                        }



//-------------------------------------------------------------------------student Menu-------------------------------------------------------------------------------------------------------------------

                    } else if (person != null && person.getPermission() == 3) {
                        Student student = studentList.get(person.getId());
                        studentMenu();
                        String input = getUserInput();
                        if (input.equals("1")) {
                            college.showStudentInformation(student);
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println();
                        } else if (input.equals("2")) {
                            college.showCoursesList();
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.println();
                        } else if (input.equals("3")) {
                            college.showCoursesList();
                            System.out.println("choice id course to take course:");
                            String idCourse = getUserInput().trim();
                            if (college.takeCourse(student, idCourse)) {
                                System.out.println(" ------------------------ course is taked---------------------------------");
                                System.out.println();
                            } else {
                                System.out.println("---------------------------student can t take course----------------------");
                            }
                        } else if (input.equals("4")) {
                            college.showStudentTakeCourse(student);
                            System.out.println("--------------------------------------------------------------------");
                            System.out.println();
                        } else if (input.equals("5")) {

                            break;
                        }

                    } else {
                        System.out.println("Exit");
                    }
                }
            }
          }





















    }
    private static String getUserInput()
    {
        input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void staffMenu(){
        System.out.println("-------Student---------");
        System.out.println("1:Enroll Student:");
        System.out.println("2:Edit Student:");
        System.out.println("3:Delete Student:");
        System.out.println("-------Professor-------");
        System.out.println("4:Enroll Professor:");
        System.out.println("5:Edit Professor:");
        System.out.println("6:Delete Professor:");
        System.out.println("-------Staff----------");
        System.out.println("7:Enroll Staff:");
        System.out.println("8:Edit Staff:");
        System.out.println("9:Delete Staff:");
        System.out.println("-------Course---------");
        System.out.println("10:Enter Course:");
        System.out.println("11:Edit Course:");
        System.out.println("12:Delete Course:");
        System.out.println("------Lists-------------");
        System.out.println("13:Student List:");
        System.out.println("14:Professor List:");
        System.out.println("15:Staff List:");
        System.out.println("16:show staff  :");
        System.out.println("17:Log out:");
    }

    private static void studentMenu(){
        System.out.println("1:Show Student Information: ");
        System.out.println("2:Show Course List :  ");
        System.out.println("3: take course:  ");
        System.out.println("4: Show Take Course:  ");
        System.out.println("5: Log out:  ");
    }

    private static void professorMenu()
    {
        System.out.println("1: Show Professor Information:  ");
        System.out.println("2: Apply student s score:  ");
        System.out.println("3: Show professor s  salary:  ");
        System.out.println("4: show Receipt professor  ");
        System.out.println("5:Log Out:  ");
    }
}
