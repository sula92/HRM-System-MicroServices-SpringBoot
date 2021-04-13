package com.sula.userservice.VO;

import com.sula.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ResponseTemplateVO {

    private User user;
    private Department department;

    public ResponseTemplateVO() {
    }

    public ResponseTemplateVO(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ResponseTemplateVO{" +
                "user=" + user +
                ", department=" + department +
                '}';
    }
}
