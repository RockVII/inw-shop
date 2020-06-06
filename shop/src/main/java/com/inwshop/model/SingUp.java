package com.inwshop.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class SingUp implements Serializable {

    private  static final  long serialVersionUID = 1L;

    private int id;
    private int roleId;

    @NotNull
    @Length(min = 3, max = 10)
    private String userName;

    @NotNull
    @Length(min = 8, max = 25)
    private String password;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 3, max = 25)
    private String firstName;

    @NotNull
    @Length(min = 3, max = 25)
    private String lastName;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$")
    private String phone;

    private int preference;

    public SingUp() {
    }

    public SingUp(int id, int roleId, String userName, String password, String email, String firstName, String lastName, String phone, int preference) {
        this.id = id;
        this.roleId = roleId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.preference = preference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "SingUp{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", preference='" + preference + '\'' +
                '}';
    }
}
