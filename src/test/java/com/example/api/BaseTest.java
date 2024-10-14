package com.example.api;

import com.example.teamcity.api.generators.TestDataStorage;
import com.example.teamcity.api.models.TestData;
import com.example.teamcity.api.requests.CheckedRequests;
import com.example.teamcity.api.spec.Specifications;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static com.example.teamcity.api.generators.TestDataGenerator.generate;

public class BaseTest {
    protected SoftAssert softy;

    protected CheckedRequests superUserCheckedRequest = new CheckedRequests(Specifications.superUserSpec());

    protected TestData testData;

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        softy = new SoftAssert();
        testData = generate();
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        softy.assertAll();
        TestDataStorage.getStorage().deleteCreatedEntites();
    }
}
