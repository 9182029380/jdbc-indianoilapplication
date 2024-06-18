package org.example.Serializable;

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 234454;
    //234454
    private  String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
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
}

public class Main {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("John Doe", 30, 50000.0);

        // Serialize the object
        try (FileOutputStream file = new FileOutputStream("C:\\Users\\Admin\\Downloads\\employee\\employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(employee);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing the object: " + e.getMessage());
        }
    }
}
