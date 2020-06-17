package com.masoud.hr.dao;


import com.masoud.hr.exception.EmployeeDuplicateException;
import com.masoud.hr.exception.EmployeeNotFoundException;
import com.masoud.hr.model.Employee;

import java.util.*;

public class EmployeeDao {
    private static List<Employee> employeeList=new ArrayList<>();
    private static Map<Integer,Employee> cashMap=new HashMap();

    public static void addEmployee(Employee employee) throws EmployeeDuplicateException {
        if(employee==null){
            throw new NullPointerException("Employee's name is null");
        }if(employeeList.contains(employee)){
            throw new EmployeeDuplicateException();
        }
        employeeList.add(employee);
        cashMap.put(employee.getPersonalCode(),employee);

    }
    public static Employee findEmployeeByPersonalCode(int employeeCode) throws EmployeeNotFoundException {
        Employee employee = cashMap.get(employeeCode);
        if (employee == null) {
            throw new EmployeeNotFoundException(String.format("Employee code is :%s not found", employeeCode));
        }
        return employee;
    }

    public static void  removeEmployee(Integer employeeCode){
        employeeList.remove(new Employee(employeeCode));
        cashMap.remove(employeeCode);
    }
    public static Set<Employee> findAllEmployeesByName(){
        if(employeeList==null || employeeList.isEmpty()){
            return Collections.emptySet();
        }
        TreeSet<Employee> employeeTreeSet=new TreeSet<>((o1, o2) -> {
            if(o1!=null && o2!=null && o1.getName()!=null && o2.getName()!=null){
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
            return 0;
        });
        employeeTreeSet.addAll(employeeList);
        return employeeTreeSet;
    }


}

