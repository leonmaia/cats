package com.lm.cats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {
    static ObjectMapper mapper = new ObjectMapper();

//    public static String toJson(Object value) throws JsonProcessingException {
//        return mapper.writeValueAsString(value);
//    }

    public static byte[] toBytes(Object value) {
        try {
            return mapper.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "".getBytes();
    }
}
