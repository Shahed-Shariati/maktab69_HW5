package HW3.repository;

import HW3.model.Student;

public class Students {
    private Student[] students = new Student[2];
    public Students()
    {
        initialStudents();
    }

    public Student[] getStudents() {
        return students;
    }

    private void initialStudents(){
        int[] id = {1,2};
        String[] nationalCode = {"6589745612","4587965412"};
        String[] firstName = {"Farid","Farhad"};
        String[] lastName = {"Irani","Faraji"};
        String[]  address = {"Tehran","Shiraz"};
        int[] permission = {3,3};
        String[] userName = {"farid","farhad"};
        String[] passWord = {"753","4567"};
        int[] avg = {14,19};
        for (int index = 0; index < id.length; index++) {
            students[index] = new Student(id[index],nationalCode[index],firstName[index],lastName[index],address[index],permission[index],userName[index],passWord[index],avg[index] );
        }
    }
}
