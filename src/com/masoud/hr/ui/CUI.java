package com.masoud.hr.ui;
import com.masoud.hr.exception.EmployeeDuplicateException;
import com.masoud.hr.exception.EmployeeNotFoundException;
import com.masoud.hr.model.Employee;
import com.masoud.hr.dao.EmployeeDao;
import java.util.Scanner;
import java.util.Set;

public class CUI {
    private static Scanner scanner=new Scanner(System.in);
    public static int getIntInput(){
        String option=scanner.nextLine();
        if(!option.matches("\\d+"))
            return getIntInput();
        return Integer.parseInt(option);
    }
    public static void main(String[] args) {


        ITERATE_LABEL:

        while (true) {
            {
                System.out.println("**********   **********   **********   **********     WELCOME TO HR-PROJECT    **********   **********   **********   **********");
                System.out.println("! (PRESS No.1)ADD  !!  (PRESS No.2)SEARCH(by id) !!  (PRESS No.3)REMOVE(by id)  !!  (PRESS No.4)SHOW ALL  !!  (PRESS No.0)EXIT !");


                int option = scanner.nextInt();

                switch (option) {
                    case 1: {
                        Employee e = inputEmployee();
                        try {
                            EmployeeDao.addEmployee(e);
                        } catch (EmployeeDuplicateException ex) {
                            System.err.println("This employee is duplicated");
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Please enter employee's personal code to search :");
                        int searchCode = getIntInput();
                        Employee employee= null;
                        try {
                            employee = EmployeeDao.findEmployeeByPersonalCode(searchCode);
                            System.out.println(employee);

                        } catch (EmployeeNotFoundException e) {
                            System.err.println("This employee is not exist");

                        }

                        break;
                    }
                    case 3: {
                        System.out.println("Please enter employee's personal code to remove :");
                        int removeByPersonalCode = getIntInput();
                        EmployeeDao.removeEmployee(removeByPersonalCode);
                        System.out.println("Removed successfully");

                        break;
                    }
                    case 4: {
                        Set<Employee> allEmployeesSortByName=EmployeeDao.findAllEmployeesByName();
                        for(Employee employee: allEmployeesSortByName){
                            System.out.println(employee);
                        }
                        break;
                    }
                    case 0: {
                        System.exit(0);
                        break ITERATE_LABEL;
                    }
                }
            }
        }
    }
    private static Employee inputEmployee() {
        System.out.println("Please Enter Employee's Name :");
        String employeeName= scanner.next();
        System.out.println("Please Enter Employee's Personal Code :");
        int employeeCode = getIntInput();
        return new Employee(employeeName,employeeCode);
    }

}
