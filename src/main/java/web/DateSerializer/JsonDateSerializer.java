package web.DateSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonDateSerializer extends JsonSerializer<Timestamp> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    @Override
//    public void serialize(LocalDateTime date, JsonGenerator generator,
//                          SerializerProvider provider) throws IOException,
//            JsonProcessingException {
//
//        String dateString = date.format(formatter);
//        generator.writeString(dateString);
//    }

    @Override
    public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        String dateString = timestamp.toString();
        jsonGenerator.writeString(dateString);
    }
}
