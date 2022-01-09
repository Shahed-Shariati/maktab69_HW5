package HW3.repository;

import HW3.model.Course;
import HW3.model.Professor;

public class Professors {
    private Professor[] professors = new Professor[2];
    public Professors()
    {
        initialProfessor();
    }

    public Professor[] getProfessors() {
        return professors;
    }

    private void initialProfessor()
    {
        Course[] courses = {new Course(1,"BR",3),new Course(2,"HU",3)};
        int[] id = {1,2};
        String[] nationalCode = {"3732789758","1234567892"};
        String[] firstName = {"James","Guido"};
        String[] lastName = {"Gosling","Rossum"};
        String[]  address = {"Canada","Netherlands"};
        int[] permission = {2,2};
        String[] userName = {"James","Guido"};
        String[] passWord = {"123","321"};
        boolean[] isStaff = {true,false};

        for (int index = 0; index < id.length; index++) {
            professors[index] = new Professor(id[index],nationalCode[index],firstName[index],lastName[index],address[index],permission[index],userName[index],passWord[index],isStaff[index],courses);
        }
    }
}
