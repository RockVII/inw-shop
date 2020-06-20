package com.inwshop.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class SingUp implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @NotNull
    private int rol;

    @NotNull
    @Length(min = 3, max = 25)
    private String name;

    @NotNull
    @Length(min = 3, max = 25)
    private String lastName;

    @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$")
    private String phone;

    @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(max = 25)
    private String password;


    public SingUp() {

    }

    public SingUp(int id, @NotNull @NotEmpty int rol, @NotNull @Length(min = 3, max = 25) String name, @NotNull @Length(min = 3, max = 25) String lastName, @Pattern(regexp = "^[0-9]{4}-[0-9]{4}$") String phone, @NotEmpty @NotNull @Email String email, @NotNull @Length(min = 8, max = 25) String password) {
        this.id = id;
        this.rol = rol;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
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

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SingUp{" +
                "id=" + id +
                ", rol=" + rol +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

