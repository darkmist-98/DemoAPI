package com.darkmist.apiUtils;

import com.darkmist.base.BaseTest;
import com.darkmist.utils.ConfigReader;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecification postNoAuthRequestSpecification(String body){
        return RestAssured.given().filter(new AllureRestAssured()).baseUri(BaseTest.getBaseUrl()).contentType(ContentType.JSON)
                .body(body);
    }

    public static RequestSpecification postAuthRequestSpecification(String body){
        return RestAssured.given().filter(new AllureRestAssured()).baseUri(BaseTest.getBaseUrl()).contentType(ContentType.JSON)
                .header("Authorization","bearer "+BaseTest.getToken())
                .body(body);
    }

    public static RequestSpecification getNoAuthRequestSpecification(){
        return RestAssured.given().filter(new AllureRestAssured()).baseUri(BaseTest.getBaseUrl()).accept("application/json");
    }

    public static RequestSpecification tokenRequestSpecification(String body){
        return RestAssured.given().baseUri(BaseTest.getBaseUrl()).contentType(ContentType.JSON).body(body);
    }

    public static RequestSpecification checkoutRequest(String body){
        return RestAssured.given().log().all().baseUri(BaseTest.getBaseUrl()).contentType(ContentType.JSON)
                .header("Authorization","bearer "+BaseTest.getToken())
                .pathParam("userId", ConfigReader.getPropertyValue("user_id"))
                .body(body);
    }
}
