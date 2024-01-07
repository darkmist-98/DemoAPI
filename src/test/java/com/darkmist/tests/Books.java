package com.darkmist.tests;

import com.darkmist.apiUtils.RequestBuilder;
import com.darkmist.base.BaseTest;
import com.darkmist.constants.Endpoints;
import com.darkmist.listeners.RetryListener;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class Books extends BaseTest {

    @Test(description = "<b>Description: Get All book list</b>", groups = {"Smoke","Regression"})
    public void getBookListTest(){
        RequestSpecification requestSpecification = RequestBuilder.getNoAuthRequestSpecification();
        Response response = requestSpecification.get(Endpoints.GET_ALL_BOOK_ENDPOINT);
        response.then().statusCode(200);
    }
}
