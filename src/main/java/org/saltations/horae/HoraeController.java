package org.saltations.horae;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;


@Controller(value = "/horae")
@Secured(SecurityRule.IS_AUTHENTICATED)
public class HoraeController {

    @Get
    public String index() {
        return "Example Response";
    }
}