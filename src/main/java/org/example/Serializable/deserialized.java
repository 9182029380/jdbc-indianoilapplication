package org.example.Serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class deserialized {
    public static void main(String[] args) {
        // Deserialize the object
        try (FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Downloads\\employee\\employee.ser");
             ObjectInputStream in = new ObjectInputStream(file)) {
            Employee deserializedEmployee = (Employee) in.readObject();
            System.out.println("Deserialized Employee: ");
            System.out.println("Name: " + deserializedEmployee.getName());
            System.out.println("Age: " + deserializedEmployee.getAge());
            System.out.println("Salary: " + deserializedEmployee.getSalary());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing the object: " + e.getMessage());
        }
    }
}
