package Employee_managment;

    public class Employee {
    String name;
    int id;
    String firstDayOfWork;
    String phoneNumber;
    String address;
    int workHours;
    double salary;
    Employee next;
    Employee prev;

    public Employee(String name, int id, String firstDayOfWork, String phoneNumber, String address, int workHours,
            double salary) {
        
        this.name = name;
        this.id = id;
        this.firstDayOfWork = firstDayOfWork;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.workHours = workHours;
        this.salary = salary;
        this.next = null;
        this.prev=null;
    }
}

  

