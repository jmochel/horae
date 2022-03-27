package org.saltations.horae;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Application Authentication Test")
public class ApplicationAuthenticationTest
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
    @DisplayName("Can login")
    void canLogin()
    {
        var credentials = new UsernamePasswordCredentials("someguy@gmail.ru", "secret");
        var req = HttpRequest.POST("/login", credentials);
        var resp = client.toBlocking().exchange(req, BearerAccessRefreshToken.class);

        assertEquals(HttpStatus.OK, resp.getStatus());
    }

}