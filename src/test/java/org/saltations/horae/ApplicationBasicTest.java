package org.saltations.horae;

import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Application Authentication Test")
public class ApplicationBasicTest
{
    @Inject
    private AuthenticationFixture loginFixture;

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

    @Test
    @Order(2)
    @DisplayName("Can get the exposed routes")
    void canGetTheRoutes()
    {
        var req = GET("/routes")
                .accept(MediaType.APPLICATION_JSON)
                .bearerAuth(loginFixture.adminAccessToken());

        var resp = client.toBlocking().retrieve(req);

        assertNotNull(resp);
    }

}