package com.fbratu.relevant.gwt.shared.dto.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Florin
 */
@Entity
@Table(name="Users")
public class User {

    @Id
    @Column(name="Id")
    private long id;

    @Column(name="UserName")
    private String userName;

    @Column(name="PassWord")
    private String password;

    public User() {
    }

    public User(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
