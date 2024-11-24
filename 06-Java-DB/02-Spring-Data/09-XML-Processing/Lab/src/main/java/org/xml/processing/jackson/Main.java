package org.xml.processing.jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.xml.processing.jackson.entities.ContactInfo;
import org.xml.processing.jackson.entities.Message;
import org.xml.processing.jackson.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        User user = new User("user", "pass", 20,
                new ContactInfo("email", "0888"),
                List.of(new Message("text-1"), new Message("text-2")));

        xmlMapper.writeValue(System.out, user);
        xmlMapper.writeValue(new File("src/main/resources/example-user.xml"), user);

//        User fromXml = xmlMapper.readValue(System.in, User.class);

        System.out.println();
    }
}
