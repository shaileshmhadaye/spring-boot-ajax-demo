package com.neo.controllers;

import com.neo.dao.DepartmentDAO;
import com.neo.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/department")
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @PostMapping(value = "/addDepartment")
    public Department postData(@RequestBody Department department){
        return departmentDAO.save(department);
    }

    @RequestMapping(value = "/list")
    public List<Department> getData(){
        return departmentDAO.findAll();
    }

}
