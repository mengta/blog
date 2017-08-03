package com.rcswu.utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonConvertUtil {
    static String jsonStr;
    public static String returnJson(Object object) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        StringWriter stringWriter=new StringWriter();
        objectMapper.writeValue(stringWriter,object);
        jsonStr=stringWriter.toString();
        return jsonStr;
    }
}
