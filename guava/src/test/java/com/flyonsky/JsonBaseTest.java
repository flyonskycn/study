package com.flyonsky;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public abstract class JsonBaseTest {

    protected static final Logger LOG = LoggerFactory.getLogger(JsonBaseTest.class);

    /**
     * json转换
     * @param json
     * @param typeReference
     * @return
     */
    protected <T> T toJson(String json, TypeReference<T> typeReference){
        ObjectMapper mapper = getMapper();
        T data = null;
        try {
            data = mapper.readValue(json, typeReference);
        } catch (IOException e) {
            LOG.error("toJson failed {}", e.getMessage());
        }
        return data;
    }

    protected <T> T toJson(InputStream inputStream, TypeReference<T> typeReference){
        ObjectMapper mapper = getMapper();
        T data = null;
        try {
            data = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            LOG.error("toJson failed {}", e.getMessage());
        }
        return data;
    }

    protected <T> T toJsonFromStream(String classPath, TypeReference<T> typeReference){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(classPath);
        return this.toJson(inputStream,typeReference);
    }

    protected void printString(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        try{
            if(obj instanceof String){
                LOG.debug(String.valueOf(obj));
            }else{
                String str = mapper.writeValueAsString(obj);
                LOG.debug(str);
            }
        }catch (Exception ex){
            LOG.debug(ex.getMessage());
        }
    }

    private ObjectMapper getMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
