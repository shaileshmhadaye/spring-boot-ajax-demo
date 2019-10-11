package com.neo.dao;

import com.neo.model.Department;
import com.neo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentDAO {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> saveAll(List<Department> departments){
        return departmentRepository.saveAll(departments);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
}
