package org.saltations.horae;

import groovy.util.logging.Slf4j;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Slf4j
@Singleton
public class AuthenticationFixture
{
    @Inject
    @Client("/")
    private HttpClient client;

    private BearerAccessRefreshToken anyGuyRefreshToken;
    private BearerAccessRefreshToken adminRefreshToken;

    String anyGuyAccessToken()
    {
        if (anyGuyRefreshToken == null)
        {
            var credentials = new UsernamePasswordCredentials("anyguy@gmail.ru", "secret");
            var req = HttpRequest.POST("/login", credentials);
            var resp = client.toBlocking().exchange(req, BearerAccessRefreshToken.class);

            this.anyGuyRefreshToken = resp.body();
        }

        return this.anyGuyRefreshToken.getAccessToken();
    }

    String adminAccessToken()
    {
        if (adminRefreshToken == null)
        {
            var credentials = new UsernamePasswordCredentials("admin@gmail.ru", "secret");
            var req = HttpRequest.POST("/login", credentials);
            var resp = client.toBlocking().exchange(req, BearerAccessRefreshToken.class);

            this.adminRefreshToken = resp.body();
        }

        return this.adminRefreshToken.getAccessToken();
    }
}
