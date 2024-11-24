package org.xml.processing.jackson.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Message {

    @JacksonXmlProperty
    private String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }
}
