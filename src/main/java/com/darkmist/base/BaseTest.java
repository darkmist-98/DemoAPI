package com.darkmist.base;
import com.darkmist.apiUtils.RequestBuilder;
import com.darkmist.constants.Endpoints;
import com.darkmist.utils.ConfigReader;
import com.darkmist.utils.JsonFileReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BaseTest {

    //private final static String BASE_URI = ConfigReader.getPropertyValue("base_uri");

    public static String getBaseUrl(){
        return baseURI = ConfigReader.getPropertyValue("base_uri");
    }
    public static String getToken() {
        JsonNode jsonNode = JsonFileReader.readJsonFile("login");
        ((ObjectNode) jsonNode).put("username", ConfigReader.getPropertyValue("username"));
        RequestSpecification requestSpecification = RequestBuilder
                .tokenRequestSpecification(jsonNode.toPrettyString());
        Response response = requestSpecification.post(Endpoints.LOGIN_ENDPOINT);
        JsonPath jsonPath = response.jsonPath();
        if (jsonPath.getString("userDetails.username").equals(ConfigReader
                .getPropertyValue("username"))) {
            return jsonPath.getString("token");
        } else {
            return null;
        }
    }
}
