package org.saltations;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This test answers the following questions about XXX_SUT
 * <ol>
 *  <li>XXX ?</li>
 *  <li>XXX ?</li>
 * </ol>
 * It does not test ...
 */

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Application Health Test")
public class ApplicationHealthTest
{
    @Inject
    @Client("/")
    private HttpClient client;

//    Title: Returns and exchanges go to inventory.
//
//    As a store owner,
//    I want to add items back to inventory when they are returned or exchanged,
//    so that I can track inventory.
//
//    Scenario 1: Items returned for refund should be added to inventory.
//    _Given_ that a customer previously bought a black sweater from me
//    _and_ I have three black sweaters in inventory,
//    _when_ they return the black sweater for a refund,
//    _then_ I should have four black sweaters in inventory.
//

    /**
     * Any rationale notes that are not covered by the scenario
     */

    @Test
    @Order(2)
    @DisplayName("Give XXX and YYY, when ZZZ then AAA")
    void applicationIsHealthy()
    {
        var result = client.toBlocking().retrieve(HttpRequest.GET("/health"));
        assertTrue(result != null);
        assertTrue(result.contains("UP"));
    }



    @Test
    @Order(4)
    @DisplayName("Give XXX and YYY, when ZZZ then AAA")
    void givenXXXAndYYYWhenZZZThenAAA()
    {
        // Arrange


        // Act


        // Assert
    }

}