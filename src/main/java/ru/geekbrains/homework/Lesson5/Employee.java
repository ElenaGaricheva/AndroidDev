package ru.geekbrains.homework.Lesson5;

public record Employee(String employeeName,
                       String employeePosition,
                       String employeeEmail,
                       String employeePhoneNum,
                       int employeeAge,
                       int employeeSalary) {
    public Employee(String employeeName, String employeePosition, int age, int salary) {
        this(employeeName, employeePosition, "email@email.com",
                "+7 999-999-99-99", age, salary);
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %s(возраст %d) состоит на должности %s с заработной платой %d.\n" +
                        "С ним можно связаться по номеру %s или отправить письмо по адресу %s.\n",
                employeeName, employeeAge, employeePosition, employeeSalary, employeePhoneNum, employeeEmail);
    }
}
