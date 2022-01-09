package HW3.utility;

import HW3.model.Student;

import java.util.Arrays;

public class StudentList {

    private Student[] students;
    int index = 0;
    public StudentList(){
        students =new Student[]{};

    }

    public boolean add(Student element) {
        int length = students.length;
        students = Arrays.copyOf(students, length + 1);
        students[length] = element;
        return true;
    }
    public Student get(int id){
        for (Student item: students) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return students.length == 0;
    }
    public int size(){
        return students.length;
    }


    public void clear()
    {
        students =new Student[]{};
    }
//    public void edit(int id,String name,int unit)
//    {
//        get(id).edit(name,unit);
//
//    }
    public void add(int index, Student element){
        int length = students.length;
        students = Arrays.copyOf(students, length + 1);
        for (int i = students.length - 1; i > index; i--) {
            students[i] = students[i - 1];
        }
        students[index] = element;
    }

    public void remove(int id){
        for (int i = 0; i < students.length ; i++) {
            if(students[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private void removeByIndex(int index)    {

        if(students.length > 0 && index <= students.length-1) {
            for (int arrayIndex = index; arrayIndex < students.length - 1; arrayIndex++) {
                students[arrayIndex] = students[arrayIndex + 1];
            }
            students = Arrays.copyOf(students, students.length - 1);
        }
    }

    public void addAll(Student[] Student){
        for (Student item: Student) {
            add(item);
        }
    }

    public void show(){
        System.out.println("id || nationalcode || firstname || lastname  || avg || ");
        for (Student Student: students) {

            System.out.println(Student);
        }
    }
    public Student[] getAll()
    {
        return students;
    }
    public boolean contains(Student number)
    {
        boolean isContain = false;
        for (Student item: students) {
            if(item == number){
                isContain = true;
                break;
            }
        }
        return isContain;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(Students)
//                ;
//    }

}
