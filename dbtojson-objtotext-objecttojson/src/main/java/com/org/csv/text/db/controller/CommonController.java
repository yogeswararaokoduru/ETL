package com.org.csv.text.db.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import com.org.csv.text.db.model.Employee;
import com.org.csv.text.db.repository.DeptRepository;
import com.org.csv.text.db.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {
    @Autowired
    private EmpRepository empRepository;
    @Autowired
    private DeptRepository deptRepository;

    public void readDataFromMongoDBToPutIntoJson() {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> emplist=empRepository.findAll();
        Employee employee=new Employee();
        employee.setEmpId(123);
        employee.setSalary(1000);
        employee.setEmpName("name");
       try {
           mapper.writeValue(new File("c:\\test\\employee.json"), employee);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public void writeJavaObjectToText(){
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        Employee employee=new Employee();
        employee.setEmpId(123);
        employee.setSalary(1000);
        employee.setEmpName("name");
        try {

            fout = new FileOutputStream("c:\\test\\employee1234.text");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(employee);

            System.out.println("Done");

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }
public void writeObjectToCsv(){
    String csv = "c:\\test\\employeeCsv.csv";
    try {
        CSVWriter writer = new CSVWriter(new FileWriter(csv));

        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"WestInddies", "17 Run"});
        data.add(new String[]{"WestInddies", "92 Run"});
        data.add(new String[]{"India", "43 Run"});
        data.add(new String[]{"Australia", "7 Run"});
        data.add(new String[]{"Pakistan", "22 Run"});
        data.add(new String[]{"Sri Lanka", "7 Wicket"});
        data.add(new String[]{"Australia", "8 Wicket"});
        data.add(new String[]{"Australia", "125 Run"});
        data.add(new String[]{"Australia", "53 Run"});
        data.add(new String[]{"India", "6 Wicket"});
        data.add(new String[]{"Australia", "7 Wicket"});
        writer.writeAll(data);
        System.out.println("CSV File written successfully All at a time");
        writer.close();
    }catch (Exception e){
        e.printStackTrace();
    }
}
}
