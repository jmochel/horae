package org.saltations.horae;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import lombok.extern.slf4j.Slf4j;

@OpenAPIDefinition(
    info = @Info(
            title = "Horae",
            version = "0.1",
            description = "Horae Service",
            license = @License(name = "Apache 2.0", url = "https://foo.bar"),
            contact = @Contact(name = "Jim Mochel", email = "jmochel@saltations.org")
    )
)
public class Application
{
    public static void main(String[] args)
    {
        Micronaut.run(Application.class, args);
    }
}
