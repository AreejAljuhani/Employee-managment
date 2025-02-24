package Employee_managment;

import java.awt.Image;
import javax.swing.*;

public class EmployeeRecordManagementSystem {

    ImageIcon validIcon = new ImageIcon("images/checkmark_icon.png");
    ImageIcon errorIcon = new ImageIcon("images/wrong_icon.png");

    Employee head;

    public EmployeeRecordManagementSystem() {

        this.head = null;

        Image dabImage = validIcon.getImage();
        Image modImage = dabImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        validIcon = new ImageIcon(modImage);

        Image dabImage1 = errorIcon.getImage();
        Image modImage1 = dabImage1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        errorIcon = new ImageIcon(modImage1);
    }

    public boolean checkRecord(int id) {
        Employee temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void insertEmployeeRecord(String name, int id, String firstDayOfWork, String phoneNumber,
            String address, int workHours, double salary) {

        Employee newEmployee = new Employee(name, id, firstDayOfWork, phoneNumber, address, workHours, salary);

        if (checkRecord(id)) {
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " does already exists in the system", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
            return;
        }

        if (head == null || id < head.id) {
            newEmployee.next = head;
            if (head != null) {
                head.prev = newEmployee;
            }
            head = newEmployee;
        } else {
            Employee temp = head;
            while (temp.next != null && temp.next.id < id) {
                temp = temp.next;
            }
            newEmployee.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newEmployee;
            }
            temp.next = newEmployee;
            newEmployee.prev = temp;
        }
        JOptionPane.showMessageDialog(null, "Employee records have been inserted successfully", "", JOptionPane.INFORMATION_MESSAGE, validIcon);
    }

    public int deleteEmployeeRecord(int id) {

        Employee temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " was not found in the system", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
            return -1;
        } else {

            if (temp == head) {
                head = temp.next;
                if (head != null) {
                    head.prev = null;
                }
            } else {
                temp.prev.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " have been deleted successfully", "", JOptionPane.INFORMATION_MESSAGE, validIcon);
            return 0;
        }
    }

    public Employee smartSearchRecord(int id) {
        Employee current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateEmployeeRecordName(String name, int id) {
        Employee temp = smartSearchRecord(id);
        temp.name = name;
    }

    public void updateEmployeeRecordFirstDay(String firstDayOfWork, int id) {
        Employee temp = smartSearchRecord(id);
        temp.firstDayOfWork = firstDayOfWork;
    }

    public void updateEmployeeRecordPhoneNum(String phoneNumber, int id) {
        Employee temp = smartSearchRecord(id);
        temp.phoneNumber = phoneNumber;
    }

    public void updateEmployeeRecordAddress(String address, int id) {
        Employee temp = smartSearchRecord(id);
        temp.address = address;
    }

    public void updateEmployeeRecordWorkHours(int workHours, int id) {
        Employee temp = smartSearchRecord(id);
        temp.workHours = workHours;
    }

    public void updateEmployeeRecordSalary(double salary, int id) {
        Employee temp = smartSearchRecord(id);
        temp.salary = salary;
    }

    public void showEmployeeDetails(int id) {

        Employee temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " was not found in the system ", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
        } else {
            JOptionPane.showMessageDialog(null, "Name: " + temp.name + "\nID: " + temp.id + "\nFirst Day of Work: " + temp.firstDayOfWork + "\nPhone Number: " + temp.phoneNumber + "\nAddress: " + temp.address + "\nWork Hours: " + temp.workHours + "\nSalary: " + temp.salary, "Employee info", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void searchEmployee(int id) {

        Employee temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " was not found in the system", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
            return;
        }
        JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " was found in the system", "", JOptionPane.INFORMATION_MESSAGE, validIcon);
    }

    public void updateEmployeeSalary(int id) {

        Employee temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }

        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Employee record with Id " + id + " was not found in the system", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
        } else {
            int extraHours = temp.workHours - 32;
            double extraSalary = 0.0;

            if (extraHours > 0) {
                extraSalary = temp.salary * (extraHours * 0.02);
            }
            temp.salary += extraSalary;

            if (extraSalary > 0) {
                JOptionPane.showMessageDialog(null, "Salary updated successfully", "", JOptionPane.INFORMATION_MESSAGE, validIcon);
            } else {
                JOptionPane.showMessageDialog(null, "There is no extra hours", "", JOptionPane.INFORMATION_MESSAGE, errorIcon);
            }
        }
    }

    public void printLinkedList() {
        Employee current = head;

        if (current == null) {
            System.out.println("Linked list is empty");
            return;
        }

        System.out.println("Printing Linked List:");
        while (current != null) {
            System.out.println("ID: " + current.id);
            System.out.println("Name: " + current.name);
            System.out.println("First Day of Work: " + current.firstDayOfWork);
            System.out.println("Phone Number: " + current.phoneNumber);
            System.out.println("Address: " + current.address);
            System.out.println("Work Hours: " + current.workHours);
            System.out.println("Salary: " + current.salary);
            System.out.println("--------------------");
            current = current.next;
        }
    }

}
