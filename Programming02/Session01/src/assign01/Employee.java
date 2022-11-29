package assign01;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(){
        this.name = "";
        this.age = 0;
        this.salary = 0;
    }
    public Employee(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && Double.compare(employee.getSalary(), getSalary()) == 0 && Objects.equals(getName(), employee.getName());
    }

    @Override
    public String toString() {
        return "Employee's name is name= " + name + '\'' +
                ", age=" + age +
                ", salary=" + salary;
    }
}
