package com.jos.dem.springboot.cucumber.user;

import com.jos.dem.springboot.cucumber.model.User;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UsersTest extends UserIntegrationTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private User user;


    @Before
    public void setup() {
        log.info("Before any test execution");
    }

    @When("^I request person by userId \"([^\"]*)\"$")
    public void shouldGetPersonByNickname(String nickname) throws Exception {
        log.info("Running: I request person by nickname at " + new Date());
        user = getUser(nickname).block();
    }

    @Then("^I validate all users$")
    public void i_validate_all_users() {
        log.info("Running: I validate User data at " + new Date());

        assertAll("person",
                () -> assertEquals(user.getName(), user.getName()),
                () -> assertEquals(user.getEmail(), user.getEmail())
        );
    }

    @After
    public void tearDown() {
        log.info("After all test execution");
    }

}

