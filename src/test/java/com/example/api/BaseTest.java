package com.example.api;

import com.example.teamcity.api.requests.CheckedRequests;
import com.example.teamcity.api.spec.Specifications;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected SoftAssert softy;

    protected CheckedRequests superUserCheckedRequest = new CheckedRequests(Specifications.superUserSpec());

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        softy = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        softy.assertAll();
    }
}
