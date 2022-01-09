package HW3.utility;

import HW3.model.Professor;

import java.util.Arrays;

public class ProfessorList {

    private Professor[] professors;
    int index = 0;
    public ProfessorList(){
        professors =new Professor[]{};

    }

    public boolean add(Professor element) {
        int length = professors.length;
        professors = Arrays.copyOf(professors, length + 1);
        professors[length] = element;
        return true;
    }
    public Professor get(int id){
        for (Professor item: professors) {
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return professors.length == 0;
    }
    public int size(){
        return professors.length;
    }


    public void clear()
    {
        professors =new Professor[]{};
    }
//    public void edit(int id,String name,int unit)
//    {
//        get(id).edit(name,unit);
//
//    }
    public void add(int index, Professor element){
        int length = professors.length;
        professors = Arrays.copyOf(professors, length + 1);
        for (int i = professors.length - 1; i > index; i--) {
            professors[i] = professors[i - 1];
        }
        professors[index] = element;
    }

    public void remove(int id){
        for (int i = 0; i < professors.length ; i++) {
            if(professors[i].getId() == id){
                removeByIndex(i);
            }
        }
    }

    private void removeByIndex(int index)    {

        if(professors.length > 0 && index <= professors.length-1) {
            for (int arrayIndex = index; arrayIndex < professors.length - 1; arrayIndex++) {
                professors[arrayIndex] = professors[arrayIndex + 1];
            }
            professors = Arrays.copyOf(professors, professors.length - 1);
        }
    }

    public void addAll(Professor[] Professor){
        for (Professor item: Professor) {
            add(item);
        }
    }

    public void show(){
        System.out.println("id || nationalcode || firstname || lastname  ||  ");
        for (Professor Professor: professors) {

            System.out.println(Professor);
        }
    }
    public Professor[] getAll()
    {
        return professors;
    }
    public boolean contains(Professor professor)
    {

        for (Professor item: professors) {
            if(item.getId() == professor.getId() ){
                return true;

            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "ProfessorList{" +
                "professors=" + Arrays.toString(professors) +
                ", index=" + index +
                '}';
    }
}
