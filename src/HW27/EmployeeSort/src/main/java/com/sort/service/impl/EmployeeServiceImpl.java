package com.sort.service.impl;

import com.sort.entity.Employee;
import com.sort.service.EmployeeService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
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
    public List<Employee> sort(List<Employee> list, Integer experience) {
            List<Employee> result = new ArrayList<>();
            for (Employee e : list) {
                if (e.getExperience() >= experience){
                    result.add(e);
                }
            }
        return result;
    }
}
