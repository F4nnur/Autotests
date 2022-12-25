package com.example.UntitledTestSuite.Generator;

import com.example.UntitledTestSuite.Entities.AccountData;
import com.example.UntitledTestSuite.Entities.NoteData;
import com.example.UntitledTestSuite.Entities.jaxb.Notes;
import com.example.UntitledTestSuite.Entities.jaxb.Users;
import com.example.UntitledTestSuite.Tests.TestBase;
import Utils.ForString;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Generator {
    public static final String dir = "D:/Autotests1/src/test/java/com/example/UntitledTestSuite/output";

    public static void main(String[] args) {
        String type = args[0];
        int count = Integer.parseInt(args[1]);
        String filename = args[2];
        String format = args[3];
        if (Objects.equals(type, "note")) GenerateForGroups(count, filename, format);
        else if (Objects.equals(type, "user")) GenerateForUsers(count, filename, format);
        else throw new IllegalArgumentException("Unrecognized type of data: " + type);
    }

    private static void GenerateForGroups(int count, String filename, String format) {
        List<NoteData> notes = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            notes.add(new NoteData(
                    TestBase.getRandomString(3, 10, 5, 18)
            ));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(dir + "/" + filename + "." + format)) {
                writeNotesToXmlFile(notes, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    static void writeNotesToXmlFile(List<NoteData> noteDataList, FileWriter fileWriter) {
        try {
            Notes notes = new Notes();
            notes.setNotes(noteDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Notes.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(notes, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static void GenerateForUsers(int count, String filename, String format) {
        List<AccountData> users = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            users.add(new AccountData(
                    ForString.getRandomString(1, 1, 8, 32),
                    ForString.getRandomStringMail(1,1,8,43),
                    ForString.getRandomPath()
            ));
        }
        if (Objects.equals(format, "xml")) {
            try (FileWriter fileWriter = new FileWriter(dir + "/" + filename + "." + format)) {
                writeUsersToXmlFile(users, fileWriter);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            throw new IllegalArgumentException("Unrecognized format: " + format);
        }
    }

    private static void writeUsersToXmlFile(List<AccountData> userDataList, FileWriter fileWriter) {
        try {;
            Users users = new Users();
            users.setUsers(userDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(users, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
