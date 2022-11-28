package projectB;

public class Employee {
    public static int employeeNum = 1000; //Employee number starts from 1000.
    String name;
    Date hiredDate;
    int id;
    String position;

    public Employee(String name, Date hiredDate,  String position) {

        this.name = name;
        this.hiredDate = hiredDate;
        this.id = employeeNum++;
        this.position = position;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee name is   " + name +  ", ID is " + id + ", hiredDate is " + hiredDate.toString() +
                ",  position is " + position;
    }
}
