package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import userDetails.userDataClass;

import java.io.IOException;
import java.io.InputStream;

public class jsonReaderClass {

    public static userDataClass getUserData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = jsonReaderClass.class
                    .getClassLoader()
                    .getResourceAsStream("testData/userData.json");

            if (is == null) {
                throw new RuntimeException("json file not found: testData/userData.json");
            }

            return mapper.readValue(is, userDataClass.class);

        } catch (IOException e) {
            throw new RuntimeException("Error reading json file", e);
        }
    }
}
