package com.mono40.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    @Column(unique = true, nullable = false, length = 30)
    private String userName;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = true, length = 60)
    private String email;
    @JsonIgnore
    @Column(nullable = false)
    private boolean active;
    @JsonIgnore
    @Column(nullable = false)
    private boolean blocked;
    private boolean emailVerified;
    private String profilePicUrl;
    private int loginFailAttempts;
    private Date lastLoginFailAttemptTime;
    private Date lastLoginDate;
    private Date creationDate;
    @Column(nullable = false)
    private boolean isPasswordChange;


    public Account() {

    }

    public Account(Long id) {
        this.id = id;
    }

    @PrePersist
    void preInsert() {
        active = true;
        blocked = false;
        isPasswordChange = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public int getLoginFailAttempts() {
        return loginFailAttempts;
    }

    public void setLoginFailAttempts(int loginFailAttempts) {
        this.loginFailAttempts = loginFailAttempts;
    }

    public Date getLastLoginFailAttemptTime() {
        return lastLoginFailAttemptTime;
    }

    public void setLastLoginFailAttemptTime(Date lastLoginFailAttemptTime) {
        this.lastLoginFailAttemptTime = lastLoginFailAttemptTime;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPasswordChange() {
        return isPasswordChange;
    }

    public void setPasswordChange(boolean passwordChange) {
        isPasswordChange = passwordChange;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "***************" + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", blocked=" + blocked +
                ", profilePicUrl='" + profilePicUrl + '\'' +
                ", loginFailAttempts=" + loginFailAttempts +
                ", lastLoginFailAttemptTime=" + lastLoginFailAttemptTime +
                ", lastLoginDate=" + lastLoginDate +
                ", creationDate=" + creationDate +
                ", passwordChange=" + isPasswordChange +
                '}';
    }
}
