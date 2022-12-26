package com.codegym.casetudy.model.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class UserRole implements Serializable {
    @Id
    @ManyToOne
    private Role role;
    @Id
    @ManyToOne
    @JoinColumn(name = "userName",referencedColumnName ="id")
    private User user;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
