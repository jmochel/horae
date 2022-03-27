package org.saltations.horae.security;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import graphql.com.google.common.collect.Lists;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Slf4j
@Requires(env = {"test","local"} )
@Singleton
public class TestAuthenticationProvider implements AuthenticationProvider
{
    @PostConstruct
    void whenConstructed()
    {
        log.info("Test Authentication Provider instantiated. You should only see this in the 'test' environment");
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest)
    {
        var login  = (String) authenticationRequest.getIdentity();
        var secret = authenticationRequest.getSecret();

        var roles = new ArrayList<String>();

        if (login.contains("admin"))
        {
            roles.add("ADMIN");
        }
        else {
            roles.add("REGULAR");
        }

        log.info("Request to authenticate {}/{}", login,secret);

        return Mono.<AuthenticationResponse>create(emitter -> {
                emitter.success(AuthenticationResponse.success( (String) login, roles));
        });
    }
}
