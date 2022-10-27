package org.saltations.app;

import io.micronaut.http.annotation.*;

@Controller("/horae")
public class HoraeController {

    @Get(uri="/")
    public final String testIt() {
        return "{ \"example\" : \"response\" }";
    }
}