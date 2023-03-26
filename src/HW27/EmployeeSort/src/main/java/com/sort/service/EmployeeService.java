package com.sort.service;

import com.sort.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList(String data);

    String sort(List<Employee> list, Integer experience);

}
