package com.sort.service.impl;

import com.sort.entity.Employee;
import com.sort.service.EmployeeService;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Getter
    @Setter
    private String rawFile;
    @Getter
    @Setter
    private String sortedFile;

    @Override
    public List<Employee> getEmployeeList(String data) {

        String[] employeeString = data.split("\r\n");
        List<Employee> result = new ArrayList<>();
        for (String s : employeeString) {
            String[] temp = s.split(" ");
            String[] temp1 = temp[1].split("\\.");
            result.add(new Employee(temp[0], temp1[0], Integer.parseInt(temp1[1])));
        }
        return result;
    }

    @Override
    public String sort(List<Employee> list, Integer experience) {
        List<Employee> temp = new ArrayList<>();
        for (Employee e : list) {
            if (e.getExperience() >= experience) {
                temp.add(e);
            }
        }

        Comparator<Employee> byNumParam = Comparator.comparingInt(Employee::getExperience);
        Comparator<Employee> byStringParam = Comparator.comparing(Employee::getLast_name);

        temp.sort(byNumParam.thenComparing(byStringParam));

        List<String> names = new ArrayList<>();
        for (Employee e : temp) {
            names.add(e.getFirst_name() + " " + e.getLast_name());
        }

        return String.join(", ", names) + ";";
    }
}
