package HW3.utility;

import HW3.model.Staff;

import java.util.Arrays;

public class StafList {
    private Staff[] staffs;
    int index = 0;

    public StafList(){
        staffs =new Staff[]{};

    }
    public Staff[] getAll()
    {
       return staffs;
    }
    public Staff authentication(String user,String pass){
        for (Staff item: staffs) {
            if(item.getUserName().equals(user) && item.getPassWord().equals(pass)){
                return item;
            }
        }
        return null;
    }
    public boolean add(Staff element) {
        int length = staffs.length;
        staffs = Arrays.copyOf(staffs, length + 1);
        staffs[length] = element;
        return true;
    }
    public Staff getByNationalCode(String nationalCode){
        for (Staff staf: staffs) {
            if(staf.getNationalCode().equals(nationalCode)){
                return staf;
            }
        }
        return null;
    }
    public Staff get(int id){
        for (Staff s: staffs) {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public boolean isEmpty(){
        return staffs.length == 0;
    }
    public int size(){
        return staffs.length;
    }


    public void clear()
    {
        staffs =new Staff[]{};
    }
    public void add(int index, Staff element){
        int length = staffs.length;
        staffs = Arrays.copyOf(staffs, length + 1);
        for (int i = staffs.length - 1; i > index; i--) {
            staffs[i] = staffs[i - 1];
        }
        staffs[index] = element;
    }

    public void remove(int id)
    {
        for (int i = 0; i < staffs.length ; i++) {
            if(staffs[i].getId() == id){
                 removeByIndex(i);
           }
        }
    }

    public  void removeByIndex(int index)
    {
        if(staffs.length > 0 && index <= staffs.length-1) {
            for (int arrayIndex = index; arrayIndex < staffs.length - 1; arrayIndex++) {
                staffs[arrayIndex] = staffs[arrayIndex + 1];
            }
            staffs = Arrays.copyOf(staffs, staffs.length - 1);
        }
    }
    public void addAll(Staff[] staff){
        for (Staff item: staff) {
            add(item);
        }
    }
    public void show(){
        System.out.println("id || nationalcode || firstname || lastname  ||  ");
        for (Staff staff : this.staffs) {
            System.out.println(staff);
        }
    }

    public boolean contains(Staff number)
    {
        boolean isContain = false;
        for (Staff item: staffs) {
            if(item == number){
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    @Override
    public String toString() {
        return "MyList "
                + Arrays.toString(staffs)
                ;
    }

}
