package com.sula.userservice.service;

import com.sula.userservice.VO.Department;
import com.sula.userservice.VO.ResponseTemplateVO;
import com.sula.userservice.entity.User;
import com.sula.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @CrossOrigin(origins = "http://localhost:9001")
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
