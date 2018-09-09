package com.simple.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Create By S I M P L E On 2018/09/09 13:45:56
 */
@Entity
public class User implements Serializable {

    @Id
    private int id;

    private String username;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
