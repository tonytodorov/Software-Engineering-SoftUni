package org.json.processing.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        PersonDTO personDTO = new PersonDTO("First", "Last", 22, false);
        ObjectMapper objectMapper = new ObjectMapper();

        String encoded = objectMapper.writeValueAsString(personDTO);

        System.out.println(encoded);

        String rawJson = """
                {"firstName":"First","lastName":"Last","age":22,"deleted":false}
                """;

        PersonDTO parsed = objectMapper.readValue(rawJson, PersonDTO.class);

        System.out.println(parsed);
    }
}
