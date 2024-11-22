package org.json.processing.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.Instant;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        PersonDTO personDTO = new PersonDTO(null, "Last", 22,
                new AddressDTO("Bulgaria", "Sofia"), true, Date.from(Instant.now()));

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("YYYY-MM-dd")
                .serializeNulls()
                .create();

        String json = gson.toJson(personDTO);
        System.out.println(json);

        PersonDTO[] personDTOFromJSON = gson.fromJson("""
               [
                  {
                    "firstName": null,
                    "age": 22,
                    "addressDTO": {
                     "country": "Bulgaria",
                     "city": "Sofia"
                   }
                 }
               ]
               """, PersonDTO[].class);

        System.out.println(personDTOFromJSON[0]);
    }
}