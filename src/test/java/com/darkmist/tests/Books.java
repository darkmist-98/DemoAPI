package com.darkmist.tests;

import com.darkmist.apiUtils.RequestBuilder;
import com.darkmist.base.BaseTest;
import com.darkmist.constants.Endpoints;
import io.qameta.allure.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

@Feature("Verify Operations on Books Module")
public class Books extends BaseTest {

    @Test(description = "Get All book list")
    @Story("Get All List of Books")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify getting list of all books")
    public void getBookListTest(){
        RequestSpecification requestSpecification = RequestBuilder.getNoAuthRequestSpecification();
        Response response = requestSpecification.get(Endpoints.GET_ALL_BOOK_ENDPOINT);
        response.then().statusCode(2001);
    }
}
