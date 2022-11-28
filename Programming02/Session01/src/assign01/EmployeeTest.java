package assign01;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee("Mickey", 25, 25000);
        Employee employee3 = new Employee("Mickey", 25, 25000);

        System.out.println("=========================================================");
        System.out.println("Display initial information of our Employee!");
        System.out.println("=========================================================");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);

        System.out.println("=========================================================");
        System.out.println("Add members and  Display information of our Employee!");
        employee1.setName("Harry");
        employee1.setAge(20);
        employee1.setSalary(10000);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);



        System.out.println("=========================================================");
        System.out.println("Find same employee");
        System.out.println("=========================================================");


        //compare to employee by using equal method.
        System.out.print("using equal method : ");
        if(employee1.equals(employee2)){
            System.out.println(employee1.getName() + " and " +employee2.getName() + " are same person." );
        }else if(employee1.equals(employee3)){
            System.out.println(employee1.getName() + " and " +employee3.getName() + " are same person." );
        }else if(employee2.equals(employee3)){
            System.out.println(employee2.getName() + " and " +employee3.getName() + " are same person." );
        }else {
            System.out.println("There are no same person.");
        }
        //compare eto employee by using toString method.
        String em01 = employee1.toString();
        String em02 = employee2.toString();
        String em03 = employee3.toString();
        System.out.print("using toString method : ");
        if(em01.contentEquals(em02)){
            System.out.println("employee1 and employee2 are same person." );
        }else if(em01.contentEquals(em03)){
            System.out.println("employee1 and employee3 are same person." );
        } else if (em02.contentEquals(em03)) {
            System.out.println("employee2 and employee3 are same person.");
        }else {
            System.out.println("There are no same person.");
        }


    }
}
