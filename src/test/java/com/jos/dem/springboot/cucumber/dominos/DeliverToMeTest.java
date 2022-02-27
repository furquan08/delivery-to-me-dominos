package com.jos.dem.springboot.cucumber.dominos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.jos.dem.springboot.cucumber.model.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliverToMeTest extends DeliverToMeIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<Response> responses;

    @Before
    public void setup() {
        log.info("Before any test execution");
    }

    @When("^I hit deliverToMeSpots with \"([^\"]*)\" latitude and \"([^\"]*)\" longitude$")
    public void shouldGetAllStores(double longitude, double latitude) throws Exception {
        log.info("Running: I request all persons at " + new Date());
        responses = deliverToMeSpots(longitude,latitude).collectList().block();

   }
   
    }

