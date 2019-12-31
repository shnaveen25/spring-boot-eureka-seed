package core.microservice.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class JSONBinder {
    private static final ObjectMapper OBJECT_MAPPER = createMapper();

    public static ObjectMapper objectMapper() {
        return OBJECT_MAPPER;
    }

    private static ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new ISO8601DateFormat());
//        mapper.setAnnotationIntrospector(new JaxbAnnotationIntrospector(TypeFactory.defaultInstance()));
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
        return mapper;
    }

    public static <T> T fromJSON(Class<T> beanClass, String json) {
        try {
            return OBJECT_MAPPER.readValue(json, beanClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJSON(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
