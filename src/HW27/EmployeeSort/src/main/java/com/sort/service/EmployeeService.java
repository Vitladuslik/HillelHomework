package com.sort.service;

import com.sort.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList(String data);

    List<Employee> sort(List<Employee> list, Integer experience);

}
