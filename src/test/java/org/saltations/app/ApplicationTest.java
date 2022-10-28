package org.saltations.app;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Horae Server")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@MicronautTest
class ApplicationTest
{
    @Inject
    private EmbeddedApplication<?> application;

    @Test
    @Order(2)
    @DisplayName("is running")
    void testItWorks()
    {
        assertTrue(application.isRunning(),"Server is not running");
    }

    @Test
    @Order(4)
    @DisplayName("returns info")
    void exposesInfo(RequestSpecification spec)
    {
        spec.when().get("/info")
            .then().statusCode(200);
    }
}
