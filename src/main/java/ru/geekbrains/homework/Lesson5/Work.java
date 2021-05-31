package ru.geekbrains.homework.Lesson5;

public class Work {
    public static Employee[] employees = new Employee[5];

    public static void main(String[] args) {
        createEmployee();

        for (Employee employee : employees) {
            if (employee.employeeAge() > 40) {
                System.out.println(employee);
            }
        }

    }

    public static void createEmployee(){
        employees[0] = new Employee("Ivan Ivanov", "QA Engineer",
                "qa@email.com", "+79999999999", 25, 5000);
        employees[1] = new Employee("Peter Petrov", "PM",
                "pm@email.com", "+78888888888", 31, 10000);
        employees[2] = new Employee("Vasya Vaseev", "PO",
                "po@email.com", "+77777777777", 41, 15000);
        employees[3] = new Employee("Nikolay Nikolayev", "Developer",
                "dev@email.com", "+76666666666", 30, 10000);
        employees[4] = new Employee("Olga Palna", "Staff",
                "staff@email.com", "+75555555555", 55, 10000);
    }
}
