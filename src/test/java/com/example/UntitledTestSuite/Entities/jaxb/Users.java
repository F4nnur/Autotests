package com.example.UntitledTestSuite.Entities.jaxb;

import com.example.UntitledTestSuite.Entities.AccountData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "user")
    private List<AccountData> users;


    public List<AccountData> getUsers() {
        return users;
    }

    public void setUsers(List<AccountData> users) {
        this.users = users;
    }

}