package org.saltations;

import io.micronaut.http.annotation.*;

@Controller("/horae")
public class HoraeController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}