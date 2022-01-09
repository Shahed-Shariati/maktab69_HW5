package HW3.utility;

import HW3.model.Person;

import java.util.Arrays;

public class PersonList {

    private Person
            [] persons;
    int index = 0;

    public PersonList() {
        persons = new Person
                []{};

    }

    public boolean add(Person element) {
        int length = persons.length;
        persons = Arrays.copyOf(persons, length + 1);
        persons[length] = element;
        return true;
    }

    public Person get(int id) {
        for (Person item : persons) {
            if (item.getId() == id ) {
                return item;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return persons.length == 0;
    }

    public int size() {
        return persons.length;
    }


    public void clear() {
        persons = new Person
                []{};
    }

    public void edit(int id, String name, int unit) {
        // get(id).edit(name,unit);
    }

    public void add(int index, Person
            element) {
        int length = persons.length;
        persons = Arrays.copyOf(persons, length + 1);
        for (int i = persons.length - 1; i > index; i--) {
            persons[i] = persons[i - 1];
        }
        persons[index] = element;
    }

    public void remove(int id) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getId() == id) {
                removeByIndex(i);
            }
        }
    }

    private void removeByIndex(int index) {

        if (persons.length > 0 && index <= persons.length - 1) {
            for (int arrayIndex = index; arrayIndex < persons.length - 1; arrayIndex++) {
                persons[arrayIndex] = persons[arrayIndex + 1];
            }
            persons = Arrays.copyOf(persons, persons.length - 1);
        }
    }

    public void addAll(Person[] Person) {
        for (Person item : Person) {
            add(item);
        }
    }

    public Person authentication(String user,String pass){
        for (Person item:persons ) {
            if(item.getUserName().equals(user) && item.getPassWord().equals(pass)){
                return item;
            }
        }
        return null;
    }
    public void show() {
        for (Person
                Person
                : persons) {

            System.out.println(Person
            );
        }
    }

    public boolean contains(Person
                                    number) {
        boolean isContain = false;
        for (Person
                item : persons) {
            if (item == number) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }


//    @Override
//    public String toString() {
//        return "MyList "
//                + Arrays.toString(Person
//                s)
//                ;
//    }

}
