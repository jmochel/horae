package org.saltations;

import io.micronaut.http.annotation.*;


@Controller(value = "/horae")
public class HoraeController {

    @Get
    public String index() {
        return "Example Response";
    }
}