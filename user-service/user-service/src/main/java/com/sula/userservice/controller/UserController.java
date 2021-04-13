package com.sula.userservice.controller;

import com.sula.userservice.VO.ResponseTemplateVO;
import com.sula.userservice.entity.User;
import com.sula.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:9001")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveDepartment(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
        return userService.getUserWithDepartment(id);
    }
}
