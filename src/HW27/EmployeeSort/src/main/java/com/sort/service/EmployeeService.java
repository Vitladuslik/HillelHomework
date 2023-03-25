package com.sort.service;

import com.sort.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();

    void sort(List<Employee> list);

}
