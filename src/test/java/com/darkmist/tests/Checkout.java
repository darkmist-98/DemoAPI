package com.darkmist.tests;

import com.darkmist.apiUtils.RequestBuilder;
import com.darkmist.base.BaseTest;
import com.darkmist.constants.Endpoints;
import com.darkmist.utils.ConfigReader;
import com.darkmist.utils.JsonFileReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Checkout extends BaseTest {

    @Test(description = "Verify check out using user id")
    public void checkoutTest(){
        JsonNode jsonNode = JsonFileReader.readJsonFile("checkout");
        RequestSpecification requestSpecification = RequestBuilder.postAuthRequestSpecification(jsonNode
                .toPrettyString());
        requestSpecification.post(Endpoints.CHECKOUT_ENDPOINT+"/"
                +ConfigReader.getPropertyValue("user_id"));
    }
}
