package com.jos.dem.springboot.cucumber.dominos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jos.dem.springboot.cucumber.model.Response;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliverToMeTest extends DeliverToMeIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Response> responses;

    @Before
    public void setup() {
        log.info("Before any test execution");
    }

    @When("^I request for  stores by \"([^\"]*)\",\"([^\"]*)\"$")
    public void iRequestForStoresBy(String longitude, String latitude) throws Exception {
        log.info("Running: I request all persons at " + new Date());
        responses = deliverToMeSpots(longitude,latitude).collectList().block();

   }

    @Then("^I validate all Stores   $")
    public void i_validate_all_stores() {
        log.info("Running: I validate User data at " + new Date());

        assertAll("Stores",
                () -> Assert.assertTrue(responses.size()>0)
        );
    }

    @After
    public void tearDown() {
        log.info("After all test execution");
    }

    }

