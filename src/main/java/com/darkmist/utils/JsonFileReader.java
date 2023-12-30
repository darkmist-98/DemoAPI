package com.darkmist.utils;

import com.darkmist.constants.FrameworkConstants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;

public class JsonFileReader {
    public static JsonNode readJsonFile(String fileName){
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.JSON_FILE_FOLDER_PATH+File.separator
                +fileName+".json")){
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(fileInputStream);
            return jsonNode;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
