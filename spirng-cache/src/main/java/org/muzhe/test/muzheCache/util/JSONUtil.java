package org.muzhe.test.muzheCache.util;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JSONUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readValue(String content, Class<T> valueType) {
        try {
            if (isNotEmpty(content)) {
                return objectMapper.readValue(content, valueType);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(InputStream ins, Class<T> valueType) {
        try {
            if (ins != null) {
                return objectMapper.readValue(ins, valueType);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(String content, TypeReference valueTypeRef) {
        try {
            if (isNotEmpty(content)) {
                return objectMapper.readValue(content, valueTypeRef);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(InputStream ins, TypeReference valueTypeRef) {
        try {
            if (ins != null) {
                return objectMapper.readValue(ins, valueTypeRef);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeValueAsString(Object value) {
        try {
            if (value != null) {
                return objectMapper.writeValueAsString(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] writeValueAsBytes(Object value) {
        try {
            if (value != null) {
                return objectMapper.writeValueAsBytes(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNotEmpty(String str) {
        return str != null && str.length() != 0;
    }
}

@JsonFilter("ThriftBeanFilter")
class ThriftBeanFilter extends SimpleBeanPropertyFilter {
    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return include(writer.getName());
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return include(writer.getName());
    }

    private boolean include(String name) {
        if (name.startsWith("set")) {
            return false;
        } else if (name.endsWith("Iterator")) {
            return false;
        } else {
            return true;
        }
    }
}