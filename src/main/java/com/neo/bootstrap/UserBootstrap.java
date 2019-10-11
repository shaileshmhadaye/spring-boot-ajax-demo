package com.neo.bootstrap;

import com.neo.dao.DepartmentDAO;
import com.neo.dao.UserDAO;
import com.neo.model.Department;
import com.neo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UserBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserDAO userDAO;
    private DepartmentDAO departmentDAO;

    public UserBootstrap(UserDAO userDAO, DepartmentDAO departmentDAO) {
        this.userDAO = userDAO;
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userDAO.saveAll(getUsers());
        departmentDAO.saveAll(getDepartments());
        log.debug("inside bootstrap file!");
    }

    private List<Department> getDepartments() {

        List<Department> departments = new ArrayList<>();

        Department computer = new Department();
        computer.setName("computer");
        computer.setLocation("parel");
        computer.setHeadOfDepartment("test");

        departments.add(computer);

        Department it = new Department();
        it.setName("IT");
        it.setLocation("thane");
        it.setHeadOfDepartment("test2");

        departments.add(it);
        return departments;
    }

    private List<User> getUsers(){

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setName("shailesh");
        user.setUsername("shailesh12");
        user.setEmail("shailesh@gmail.com");
        user.setPassword("password");
        user.setMobile("1234567896");
        user.setStatus("unmarried");
        //user.setDepartment();

        users.add(user);

        User user1 = new User();
        user1.setName("raj");
        user1.setUsername("raj12");
        user1.setPassword("password");
        user1.setEmail("raj@gmail.com");
        user1.setMobile("2345729823");
        user1.setStatus("married");
        //user1.setDepartment(department);

        users.add(user1);

        return users;
    }
}
