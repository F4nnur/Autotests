package com.example.UntitledTestSuite.Entities;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountData {
    @XmlElement(name = "username", required = true)
    public String username;
    @XmlElement(name = "password", required = true)
    public String password;
    @XmlElement(name = "path", required = true)
    public String path;

    public AccountData(){}

    public AccountData(String username, String password, String path) {
        this.username = username;
        this.password = password;
        this.path = path;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountData userData)) return false;
        return Objects.equal(username, userData.username)
                && Objects.equal(password, userData.password)
                && Objects.equal(path, userData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password, path);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", path='" + path + '\'' +
                '}';
    }


}


