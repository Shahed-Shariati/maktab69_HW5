package HW3.model;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String nationalCode;
    private int permission;
    private String userName;
    private String passWord;

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Person(){

    }

    public Person(int id,String nationalCode, String firstName, String lastName, String address, int permission, String userName, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.permission = permission;
        this.userName = userName;
        this.passWord = passWord;
        this.nationalCode = nationalCode;
    }
    public String getFullName()
    {
        return this.firstName + " " + lastName;
    }
    @Override
    public String toString() {
        return
                "national code=" + nationalCode +
                " id=" + id + '\''+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\''
                ;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }
}
