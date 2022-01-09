package HW3.model;

import HW3.model.Person;

abstract public class Employee extends Person {
    public Employee(int id ,String nationalCode,String firstName,String lastName,String address,int permission,String userName,String password){
        super(id,nationalCode,firstName,lastName,address,permission,userName,password);
    }
   abstract  public int salary();


    @Override
    public String toString() {
        return super.toString();
    }
}
