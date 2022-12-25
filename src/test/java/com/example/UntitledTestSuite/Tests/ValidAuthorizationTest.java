package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.Entities.AccountData;
import com.example.UntitledTestSuite.Entities.jaxb.Users;
import com.example.UntitledTestSuite.Generator.Generator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class ValidAuthorizationTest extends TestBase{

    @DataPoints
    public static List<AccountData> usersFromXmlFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(Generator.dir + "/valid_users.xml"));
            return users.getUsers();
        } catch (JAXBException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Test
    @Theory
    public void authorization(AccountData user) throws Exception {
        appManager.getNavigation().GetLoginPage();
        appManager.getLogin().login(user);
        appManager.getLogin().SubmitData();
        //Assert.assertTrue("Check passwd and login", appManager.getLogin().isAuthorized());
    }
}
