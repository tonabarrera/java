package com.tona.backendninja.entity;

import javax.persistence.*;

/**
 * @author tona created on 17/03/2018 for backendninja.
 */
@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "user"}))
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole(Integer userRoleId, User user, String role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
